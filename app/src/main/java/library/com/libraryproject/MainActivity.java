package library.com.libraryproject;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import library.com.httphelper.HttpHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpHelper.HttpConfig config = new HttpHelper.HttpConfig() {
            @Override
            public String baseUrl() {
                //配置retrofit中的baseUrl
                return "http://api.douban.com/v2/movie/subject/";
            }

            @Override
            public String codeFieldName() {
                //code的字段名
                return "code";
            }

            @Override
            public int codeSuc() {
                //code成功的判定，boolean类型可以返回1
                return 0;
            }

            @Override
            public String msgFieldName() {
                //msg的字段名
                return "msg";
            }

            @Override
            public String dataFieldName() {
                //data的字段名
                return "data";
            }
        };

        HttpHelper.DEFAULT.config(getApplication(), config);
    }

    public void onClick(View view) {
        execute();
    }

    private void execute() {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("apikey", "0b2bdeda43b5688921839c8ecb20399b");
        HttpHelper.DEFAULT.execute(new HttpHelper.Request<DataBean>("26004132", paramMap) {
            @Override
            public void onSuccess(DataBean data) {
                Toast.makeText(MainActivity.this, "execute success", Toast.LENGTH_LONG).show();
            }
        }, true);

        String downloadUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525434778095&di=1088e524ff80610eae30cbc41608bc28&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fb21c8701a18b87d6232299000d0828381f30fd48.jpg";

        File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + "/downloadImg.jpg");

        HttpHelper.DEFAULT.download(new HttpHelper.Request<File>(downloadUrl, file) {
            @Override
            public void onSuccess(File data) {

            }

            @Override
            public void onError(int code, String err) {
                super.onError(code, err);
            }
        });
    }
}
