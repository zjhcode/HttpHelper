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
            public String getBaseUrl() {
                return "http://www.kuaidi100.com/";
            }

            @Override
            public String getCodeKey() {
                return "status";
            }

            @Override
            public String getMsgKey() {
                return "message";
            }

            @Override
            public int getCodeSuc() {
                return 200;
            }
        };

        HttpHelper.DEFAULT.config(getApplication(), config);
    }

    public void onClick(View view) {
        String url = "query";
        Map<String, String> map = new HashMap<>();
        map.put("type", "ems");
        map.put("postid", "1115983271809");
        HttpHelper.DEFAULT.execute(new HttpHelper.Request<Object>(url, map) {
            @Override
            public void onSuccess(Object reslut) {

            }
        });
    }
}
