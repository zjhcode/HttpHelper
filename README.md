# HttpHelper
this is a simple and easy to use network framework library

# 引用

在工程的build.gradle中添加
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

在module的build.gradle中添加
```
implementation 'com.github.zjhcode:HttpHelper:0.0.1'
```

# 权限
```
在AndroidManifest中添加如下权限
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

# 使用

通过HttpConfig配置HttpHelper<br>
建议在Application中进行配置：
```
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
```
传入接口的url和参数map发起请求
```
HttpHelper.DEFAULT.execute(new HttpHelper.Request<Object>(url, map) {
    @Override
    public void onSuccess(Object reslut) {

    }
});
```
