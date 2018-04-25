package library.com.libraryproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("apikey", "0b2bdeda43b5688921839c8ecb20399b");
        HttpHelper.DEFAULT.execute(new HttpHelper.Request<DataBean>("26004132", paramMap) {
            @Override
            public void onSuccess(DataBean reslut) {
                String alt = reslut.getAlt();
                Toast.makeText(MainActivity.this, alt, Toast.LENGTH_LONG).show();
            }
        }, true);
    }

    public void onClick(View view) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("apikey", "0b2bdeda43b5688921839c8ecb20399b");
        HttpHelper.DEFAULT.execute(new HttpHelper.Request<DataBean>("26004132", paramMap, HttpHelper.Request.RequestType.GET) {
            @Override
            public void onSuccess(DataBean reslut) {
                String alt = reslut.getAlt();
                Toast.makeText(MainActivity.this, alt, Toast.LENGTH_LONG).show();
            }
        }, true);
    }
}
