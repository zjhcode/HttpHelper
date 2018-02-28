# HttpHelper
this is a simple and easy to use network framework library

第一步：
通过HttpConfig配置BaseUrl,code,message

      HttpHelper.HttpConfig config = new HttpHelper.HttpConfig() {
            @Override
            public String getBaseUrl() {
                return "baseUrl";
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

       

第二步：
传入url与参数map并执行即可完成网络请求。

        HttpHelper.DEFAULT.execute(new HttpHelper.Request<Object>(url, map) {
            @Override
            public void onSuccess(Object reslut) {

            }
        });

