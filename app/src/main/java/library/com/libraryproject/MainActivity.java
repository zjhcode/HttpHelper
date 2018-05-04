package library.com.libraryproject;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import library.com.httphelper.HttpHelper;

public class MainActivity extends AppCompatActivity {
    private TextView progressTextView;
    private Runnable progressRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressTextView = findViewById(R.id.progress_tv);

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

        String downloadUrl = "http://115.231.191.148/sqdd.myapp.com/myapp/qqteam/tim/down/tim.apk?mkey=5aec0f15278da642&f=4eae&c=0&p=.apk";

        File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + "/zzm.apk");

        HttpHelper.DEFAULT.download(new HttpHelper.Request<File>(downloadUrl, file) {
            @Override
            public void onDownloadStart(final long fileSize) {
                super.onDownloadStart(fileSize);

                progressTextView.post(progressRunnable = new Runnable() {
                    @Override
                    public void run() {
                        progressTextView.setText(String.format("%.2f %%", 100 * ((double) file.length()) / fileSize));

                        progressTextView.postDelayed(this, 200);
                    }
                });
            }

            @Override
            public void onSuccess(File data) {
                Toast.makeText(MainActivity.this, "下载完成,文件位于：" + data.getAbsolutePath(), Toast.LENGTH_LONG).show();
                progressTextView.removeCallbacks(progressRunnable);
                progressTextView.setText("100.00%");
            }

            @Override
            public void onError(int code, String err) {
                super.onError(code, err);
                progressTextView.removeCallbacks(progressRunnable);
            }
        });
    }
}
