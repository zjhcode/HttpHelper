package library.com.httphelper;


import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;

import java.io.File;
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
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

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
    private static final int CODE_CUSTOM_ERROR = -100;
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

    public <D> void execute(final Request<D> request) {
        execute(request, false);
    }

    /**
     * 执行请求
     *
     * @param request
     * @param parseOverall 是否解析并返回整个json实体
     * @param <D>
     */
    @SuppressLint("CheckResult")
    @SuppressWarnings("unchecked")
    public <D> void execute(final Request<D> request, final boolean parseOverall) {
        if (ObjectUtils.isEmpty(config)) {
            LogUtils.eTag("HttpHelper", "u must use config() first!");
            return;
        }

        if (!NetworkUtils.isConnected()) {
            ToastUtils.showLong("网络连接失败,请检查网络连接");
            return;
        }

        String executeLog = String.format("request execute\nurl:\n%s\nparams:%s", retrofit.baseUrl().toString() + request.url, request.paramMap.toString());
        LogUtils.dTag("HttpHelper", executeLog);

        request.buildRequest(getNetService())
                .subscribeOn(Schedulers.io())
                .map(new Function<String, D>() {
                    @Override
                    public D apply(String json) throws Exception {
                        LogUtils.dTag("debug", "map:" + Thread.currentThread().getName());
                        JSONObject jsonObject = JSON.parseObject(json);
                        int code;
                        String msg;
                        String dataJson;

                        String codeField = jsonObject.getString(config.codeFieldName());
                        if (ObjectUtils.isEmpty(codeField)) {
                            codeField = "";
                        }
                        //对boolean类型的兼容
                        switch (codeField) {
                            case "true":
                                code = 1;
                                break;
                            case "false":
                                code = 0;
                                break;
                            default:
                                code = jsonObject.getIntValue(config.codeFieldName());
                        }

                        msg = jsonObject.getString(config.msgFieldName());

                        //是否解析全部json数据
                        if (parseOverall) {
                            dataJson = json;
                        } else {
                            dataJson = jsonObject.getString(config.dataFieldName());
                            //对于后台数据格式容错的判断
                            if (TextUtils.isEmpty(dataJson) || dataJson.equals("null")) {
                                dataJson = "";
                            }
                        }

                        String dataTag = encoded ? "data decode" : "data default";
                        if (code == config.codeSuc()) {
                            if (encoded) {
                                if (!TextUtils.isEmpty(dataJson)) {
                                    //解密
                                    dataJson = config.decode(dataJson);
                                }
                            }

                            String dataLog = String.format("url:\n%s\nparams:%s\n%s:\n%s", retrofit.baseUrl().toString() + request.url, request.paramMap.toString(), dataTag, dataJson);
                            LogUtils.dTag("HttpHelper", dataLog);

                            Type type = request.getClass().getGenericSuperclass();
                            if (type instanceof ParameterizedType) {
                                Type paramType = ((ParameterizedType) type).getActualTypeArguments()[0];
                                if (paramType.equals(String.class)) {
                                    return (D) dataJson;
                                }

                                return JSON.parseObject(dataJson, paramType);
                            }

                            return (D) dataJson;
                        }

                        throw new NetException(code, msg);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<D>() {
                    @Override
                    public void accept(D data) throws Exception {
                        request.onSuccess(data);
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
                        LogUtils.dTag("HttpHelper", errLog);

                        request.onError(code, throwable.getMessage());
                    }
                });
    }

    @SuppressLint("CheckResult")
    public void download(final Request<File> request) {
        getNetService().download(request.url)
                .subscribeOn(Schedulers.io())
                .map(new Function<ResponseBody, File>() {
                    @Override
                    public File apply(ResponseBody responseBody) throws Exception {
                        if (FileIOUtils.writeFileFromIS(request.file, responseBody.byteStream())) {
                            return request.file;
                        }

                        throw new NetException(CODE_CUSTOM_ERROR, "下载失败");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<File>() {
                    @Override
                    public void accept(File file) throws Exception {
                       request.onSuccess(file);
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

                        request.onError(code, throwable.getMessage());
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
    public static abstract class Request<D> {
        protected String url;
        protected Map<String, String> paramMap;
        protected File file;
        protected RequestType requestType;
        protected ParamType paramType;

        public Request(String url, Map map) {
            this.url = url;
            this.paramMap = map;
            this.requestType = RequestType.POST;
            this.paramType = ParamType.NORMAL;
        }

        public Request(String url, File file) {
            this.url = url;
            this.file = file;
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

        public abstract void onSuccess(D data);

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

        @Streaming
        @GET
        Observable<ResponseBody> download(@Url String url);
    }
}
