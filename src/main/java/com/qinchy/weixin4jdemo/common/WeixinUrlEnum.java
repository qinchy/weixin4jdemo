package com.qinchy.weixin4jdemo.common;

public enum WeixinUrlEnum {

    /**
     * 菜单
     */
    MENU_CREATE("POST", "https://api.weixin.qq.com/cgi-bin/menu/create?access_token={ACCESS_TOKEN}"),

    MENU_GET("GET", "https://api.weixin.qq.com/cgi-bin/menu/get?access_token={ACCESS_TOKEN}"),

    MENU_DELETE("GET", "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token={ACCESS_TOKEN}"),

    MENU_ADDCONDITIONAL("POST", "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token={ACCESS_TOKEN}"),

    /**
     * 微信服务器IP地址
     */
    IP_GET("GET", "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token={ACCESS_TOKEN}"),

    /**
     * 客服
     */
    KEFU_ADD("POST","https://api.weixin.qq.com/customservice/kfaccount/add?access_token={ACCESS_TOKEN}"),
    KEFU_UPDATE("POST","https://api.weixin.qq.com/customservice/kfaccount/update?access_token={ACCESS_TOKEN}"),
    KEFU_DELETE("GET","https://api.weixin.qq.com/customservice/kfaccount/del?access_token={ACCESS_TOKEN}"),
    /**
     * 获取所有客服账号
     */
    KEFU_LIST("GET","https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token={ACCESS_TOKEN}"),
    /**
     * 客服接口-发消息
     */
    KEFU_SEND("POST","https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token={ACCESS_TOKEN}"),

    /**
     * 卡券
     */
    CARD_CREATE("POST","https://api.weixin.qq.com/card/create?access_token={ACCESS_TOKEN}"),
    QRCODE_CREATE("POST","https://api.weixin.qq.com/card/qrcode/create?access_token={ACCESS_TOKEN}"),
    ;

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

    WeixinUrlEnum(String method, String url) {
        this.method = method;
        this.url = url;
    }
}
