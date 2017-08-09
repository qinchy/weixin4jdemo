package com.qinchy.weixin4jdemo.common;

import com.qinchy.weixin4jdemo.schedule.AccessTokenSchedule;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class WeixinRequestUtils {

    public static String request(WeixinUrlEnum.Menu menu, String body) {
        String method = menu.getMethod();
        String url = menu.getUrl();
        String accessToken = AccessTokenSchedule.getInstance().getAccessToken();
        url = url.replace("{ACCESS_TOKEN}", accessToken);

        Map<String, String> param = new HashMap<String, String>();
        if (StringUtils.isNotBlank(body)) {
            param.put("body", body);
        }

        String result = "";
        if (StringUtils.equalsIgnoreCase("post", method)) {
            result = HttpUtils.post(url, param, "UTF-8");
        } else {
            result = HttpUtils.get(url, param, "UTF-8");
        }

        return result;
    }
}
