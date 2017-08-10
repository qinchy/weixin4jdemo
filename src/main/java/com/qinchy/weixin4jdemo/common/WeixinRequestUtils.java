package com.qinchy.weixin4jdemo.common;

import com.qinchy.weixin4jdemo.schedule.AccessTokenSchedule;
import org.apache.commons.lang.StringUtils;

public class WeixinRequestUtils {

    public static String request(WeixinUrlEnum.Menu menu, String body) {
        String method = menu.getMethod();
        String url = menu.getUrl();
        String accessToken = AccessTokenSchedule.getInstance().getAccessToken();
        url = url.replace("{ACCESS_TOKEN}", accessToken);

        String result = "";
        if (StringUtils.equalsIgnoreCase("post", method)) {
            result = HttpUtils.post(url, body, "UTF-8");
        } else {
            // get传参数加到url中吧，这里params传null
            result = HttpUtils.get(url, null, "UTF-8");
        }

        return result;
    }
}
