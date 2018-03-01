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

# 使用

通过HttpConfig配置HttpHelper
建议在Application中进行配置：
```
HttpHelper.HttpConfig config = new HttpHelper.HttpConfig() {
    @Override
    public String getBaseUrl() {
        //配置retrofit的baseUrl
        return "http://www.kuaidi100.com/";
    }

    @Override
    public String getCodeKey() {
        //返回的json中code的字段名
        return "code";
    }

    @Override
    public String getMsgKey() {
        //返回的json中msg的字段名
        return "msg";
    }

    @Override
    public int getCodeSuc() {
        //code成功的判定值
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
