package library.com.httphelper;


import android.app.Application;
import android.text.TextUtils;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * 网络框架类
 * （基于Retrofit2,RxJava2）
 * <p>
 * Created by zjh on 2017/8/14.
 */
public enum HttpHelper {
    DEFAULT(false), ENCODED(true);

    private static final String TAG = "debug";
    private Retrofit retrofit;
    private NetService netService;
    private boolean encoded;

    private HttpConfig config;
    private OkHttpClient client;
    private final Interceptor logInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    //是否使用拦截器
    private static final boolean USE_INTERCEPTOR = true;
    private static final int CODE_REQUEST_THROWABLE = -1;
    //超时
    private static final int TIMEOUT = 60;
    private static final String DEFAULT_BASE_URL = "http://default.com/";

    HttpHelper(boolean encoded) {
        this.encoded = encoded;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.connectTimeout(TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(TIMEOUT, TimeUnit.SECONDS);

        //builder.addInterceptor(logInterceptor);

        retrofit = new Retrofit.Builder()
                .client(client = builder.build())
                .baseUrl(DEFAULT_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void config(Application app, HttpConfig httpConfig) {
        Utils.init(app);
        config = httpConfig;
        OkHttpClient.Builder builder = client.newBuilder();

        if (USE_INTERCEPTOR) {
            if (encoded) {
                builder.addInterceptor(httpConfig.encodedInterceptor());

            } else {
                builder.addInterceptor(httpConfig.defaultInterceptor());

            }
        }

        retrofit = retrofit.newBuilder()
                .client(builder.build())
                .baseUrl(httpConfig.baseUrl())
                .build();
    }

    public NetService getNetService() {
        if (netService == null) {
            return netService = retrofit.create(NetService.class);
        }
        return netService;
    }

    @SuppressWarnings("unchecked")
    public <R> void execute(final Request<R> request) {
        if (!NetworkUtils.isConnected()) {
            ToastUtils.showLong("网络连接失败,请检查网络连接");
            return;
        }

        String executeLog = String.format("request execute\nurl:\n%s\nparams:%s", retrofit.baseUrl().toString() + request.url, request.paramMap.toString());
        LogUtils.dTag("OkHttp", executeLog);

        request.buildRequest(getNetService())
                .subscribeOn(Schedulers.io())
                .map(new Function<String, R>() {
                    @Override
                    public R apply(String json) throws Exception {
                        LogUtils.dTag("debug", "map:" + Thread.currentThread().getName());
                        JSONObject jsonObject = new JSONObject(json);
                        String codeFieldName = (config == null ? "code" : config.codeFieldName());
                        int code;
                        String codeStr = jsonObject.getString(codeFieldName);
                        //对boolean类型的兼容
                        switch (codeStr) {
                            case "true":
                                code = 1;
                                break;
                            case "false":
                                code = 0;
                                break;
                            default:
                                code = jsonObject.getInt(codeFieldName);
                        }

                        String msg = jsonObject.getString(config == null ? "msg" : config.msgFieldName());
                        String dataJson = jsonObject.getString(config == null ? "msg" : config.dataFieldName());
                        //对于后台数据格式容错的判断
                        if (TextUtils.isEmpty(dataJson) || dataJson.equals("null")) {
                            dataJson = "";
                        }
                        String dataTag = encoded ? "data decode" : "data default";
                        if (code == (config == null ? 200 : config.codeSuc())) {
                            if (encoded) {
                                if (!TextUtils.isEmpty(dataJson)) {
                                    //解密
                                    dataJson = (config == null ? dataJson : config.decode(dataJson));
                                }
                            }

                            String dataLog = String.format("url:\n%s\nparams:%s\n%s:\n%s", retrofit.baseUrl().toString() + request.url, request.paramMap.toString(), dataTag, dataJson);
                            LogUtils.dTag("OkHttp", dataLog);

                            Type type = request.getClass().getGenericSuperclass();
                            if (type instanceof ParameterizedType) {
                                Type paramType = ((ParameterizedType) type).getActualTypeArguments()[0];
                                if (paramType.equals(Object.class) || paramType.equals(String.class)) {
                                    return (R) dataJson;
                                }

                                return new Gson().fromJson(dataJson, paramType);
                            }
                            return (R) dataJson;
                        }

                        throw new NetException(code, msg);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<R>() {
                    @Override
                    public void accept(R result) throws Exception {
                        request.onSuccess(result);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        int code;
                        String msg = throwable.getMessage();
                        if (throwable instanceof NetException) {
                            NetException netException = (NetException) throwable;
                            code = netException.code;
                        } else {
                            code = CODE_REQUEST_THROWABLE;
                        }

                        String errLog = String.format("url:\n%s\nparams:%s\nerr:\ncode:%s msg:%s", retrofit.baseUrl().toString() + request.url, request.paramMap.toString(), String.valueOf(code), msg);
                        LogUtils.dTag("OkHttp", errLog);

                        request.onError(CODE_REQUEST_THROWABLE, throwable.getMessage());
                    }
                });
    }

    public static abstract class HttpConfig {

        public abstract String baseUrl();

        public abstract String codeFieldName();

        public abstract int codeSuc();

        public abstract String msgFieldName();

        public abstract String dataFieldName();

        public String decode(String dataJson) {
            return dataJson;
        }

        public Interceptor defaultInterceptor() {
            return new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    return chain.proceed(chain.request());
                }
            };
        }

        public Interceptor encodedInterceptor() {
            return new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    return chain.proceed(chain.request());
                }
            };
        }
    }

    @SuppressWarnings(value = {"path", "cast"})
    public static abstract class Request<R> {
        protected String url;
        protected Map<String, String> paramMap;
        protected RequestType requestType;
        protected ParamType paramType;

        public Request(String url, Map map) {
            this.url = url;
            this.paramMap = map;
            this.requestType = RequestType.POST;
            this.paramType = ParamType.NORMAL;
        }

        public Request(String url, Map map, RequestType requestType) {
            this.url = url;
            this.paramMap = map;
            this.requestType = requestType;
            this.paramType = ParamType.NORMAL;
        }

        public Request(String url, Map map, ParamType paramType) {
            this.url = url;
            this.paramMap = map;
            this.requestType = RequestType.POST;
            this.paramType = paramType;
        }

        public Request(String url, Map map, RequestType requestType, ParamType paramType) {
            this.url = url;
            this.paramMap = map;
            this.requestType = requestType;
            this.paramType = paramType;
        }

        protected Observable buildRequest(NetService netService) {
            if (customRequest() != null) {
                return customRequest();
            }

            switch (paramType) {
                case NORMAL:
                    if (RequestType.GET == requestType) {
                        return netService.get(url, paramMap);
                    }

                    return netService.post(url, paramMap);
                case FIELD:
                    if (RequestType.GET == requestType) {
                        return netService.getField(url, paramMap);
                    }

                    return netService.postField(url, paramMap);
                case BODY:
                    if (RequestType.GET == requestType) {
                        return netService.getBody(url, paramMap);
                    }

                    return netService.postBody(url, paramMap);
            }
            return null;
        }

        public Observable customRequest() {
            return null;
        }

        public abstract void onSuccess(R reslut);

        public void onError(int code, String err) {

        }

        public enum RequestType {
            GET, POST;
        }

        public enum ParamType {
            NORMAL, FIELD, BODY;
        }
    }

    public class NetException extends Exception {
        private int code;

        public NetException(int code, String message) {
            super(message);
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

    public interface NetService {
        @GET("{url}")
        Observable<String> get(@Path(value = "url", encoded = true) String url, @QueryMap Map<String, String> map);

        @POST("{url}")
        Observable<String> post(@Path(value = "url", encoded = true) String url, @QueryMap Map<String, String> map);

        @FormUrlEncoded
        @GET("{url}")
        Observable<String> getField(@Path(value = "url", encoded = true) String url, @FieldMap Map<String, String> map);

        @FormUrlEncoded
        @POST("{url}")
        Observable<String> postField(@Path(value = "url", encoded = true) String url, @FieldMap Map<String, String> map);

        @GET("{url}")
        Observable<String> getBody(@Path(value = "url", encoded = true) String url, @Body Map<String, String> map);

        @POST("{url}")
        Observable<String> postBody(@Path(value = "url", encoded = true) String url, @Body Map<String, String> map);
    }
}
