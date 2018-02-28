# HttpHelper
this is a simple and easy to use network framework library

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
        
通过HttpConfig配置BaseUrl,code,messag

HttpHelper.DEFAULT.execute(new HttpHelper.Request<Object>(url, map) {
            @Override
            public void onSuccess(Object reslut) {

            }
        });
执行时传入url与参数的map即可完成网络请求。
