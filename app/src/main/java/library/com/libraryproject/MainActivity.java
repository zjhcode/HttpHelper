package library.com.libraryproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
                return "baseUrl";
            }

            @Override
            public String codeFieldName() {
                //code的字段名
                return "code";
            }

            @Override
            public int codeSuc() {
                //code成功的判定，boolean类型可以返回1
                return 200;
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
        String url = "url";
        Map<String, String> map = new HashMap<>();

        HttpHelper.DEFAULT.execute(new HttpHelper.Request<Object>(url, map) {
            @Override
            public void onSuccess(Object reslut) {

            }
        });
    }
}
