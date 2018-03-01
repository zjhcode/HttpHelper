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
implementation 'com.github.zjhcode:HttpHelper:0.0.1'

# 使用

通过HttpConfig配置HttpHelper

baseUrl:设置retrofit的baseUrl
codeKey:请求返回的json中code字段的名称
msgkey:请求返回的json中message字段的名称
codeSuc:code正确的判定值

建议写在Application中进行配置：
```
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
```
传入接口的url和参数map发起请求
```
HttpHelper.DEFAULT.execute(new HttpHelper.Request<Object>(url, map) {
    @Override
    public void onSuccess(Object reslut) {

    }
});
```
