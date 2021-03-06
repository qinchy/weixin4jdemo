package com.qinchy.weixin4jdemo.common;

import com.alibaba.fastjson.JSONObject;
import com.qinchy.weixin4jdemo.schedule.AccessTokenSchedule;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weixin4j.WeixinException;
import org.weixin4j.http.HttpsClient;
import org.weixin4j.http.Response;

public class WeixinRequestUtils {

    private static Logger log = LoggerFactory.getLogger(WeixinRequestUtils.class);

    public static String request(WeixinUrlEnum urlEnum, String body, String dataType) {
        String method = urlEnum.getMethod();
        String url = urlEnum.getUrl();
        String accessToken = AccessTokenSchedule.getInstance().getAccessToken();
        url = url.replace("{ACCESS_TOKEN}", accessToken);

        String result = "";
/*
        if (StringUtils.equalsIgnoreCase("post", method)) {
            result = HttpUtils.post(url, body, "UTF-8");
        } else {
            // get传参数加到url中吧，这里params传null
            result = HttpUtils.get(url, null, "UTF-8");
        }
*/

        HttpsClient client = new HttpsClient();
        try {
            if (StringUtils.equalsIgnoreCase("post", method)) {
                if (StringUtils.equalsIgnoreCase("JSON", dataType)) {
                    Response response = client.post(url, JSONObject.parseObject(body));
                    result = response.asString();
                } else if (StringUtils.equalsIgnoreCase("XML", dataType)) {
                    Response response = client.postXml(url, body);
                    result = response.asString();
                }
            } else {
                Response response = client.get(url);
                result = response.asString();
            }
        } catch (WeixinException e) {
            log.error("发送请求时报错", e);
        }

        return result;
    }
}
