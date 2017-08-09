package com.qinchy.weixin4jdemo.common;

public class WeixinUrlEnum {
    public enum Menu {
        CREATE("POST", "https://api.weixin.qq.com/cgi-bin/menu/create?access_token={ACCESS_TOKEN}"),
        GET("GET", "https://api.weixin.qq.com/cgi-bin/menu/get?access_token={ACCESS_TOKEN}"),
        DELETE("GET", "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token={ACCESS_TOKEN}"),
        ADDCONDITIONAL("POST", "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token={ACCESS_TOKEN}");

        private String method;
        private String url;

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        Menu(String method, String url) {
            this.method = method;
            this.url = url;
        }
    }
}
