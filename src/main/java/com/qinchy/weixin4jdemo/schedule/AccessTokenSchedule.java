package com.qinchy.weixin4jdemo.schedule;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.weixin4j.Configuration;
import org.weixin4j.WeixinException;
import org.weixin4j.http.HttpsClient;

@Component
public class AccessTokenSchedule {

    private Logger log = LoggerFactory.getLogger(AccessTokenSchedule.class);

    public final static long ONE_HOUR = 60 * 60 * 1000;

    private static AccessTokenSchedule instance = null;

    private AccessTokenSchedule() {

    }

    public static AccessTokenSchedule getInstance() {
        if (null == instance) {
            synchronized (AccessTokenSchedule.class) {
                if (null == instance) {
                    instance = new AccessTokenSchedule();
                }
            }
        }
        return instance;
    }

    private String accessToken;

    private void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        if (StringUtils.isBlank(accessToken)) {
            retrieveAccessToken();
        }
        return this.accessToken;
    }

    @Scheduled(fixedDelay = ONE_HOUR)
    private void retrieveAccessToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                + Configuration.getProperty("weixin4j.oauth.appid") + "&secret=" + Configuration.getProperty("weixin4j.oauth.secret");

        HttpsClient client = new HttpsClient();
        try {
            String rtnMsg = client.get(url).asString();
            log.info("access_token请求返回串：" + rtnMsg);

            JSONObject jsonObject = JSONObject.fromObject(rtnMsg);
            if (jsonObject.containsKey("access_token")) {
                String token = jsonObject.getString("access_token");

                if (Configuration.isDebug()) {
                    log.debug("access_token = " + token);
                }

                setAccessToken(token);
            } else {
                if (Configuration.isDebug()) {
                    log.debug("请求错误，未返回access_token");
                }
            }
        } catch (WeixinException e) {
            log.error("获取access_token的schedule报错", e);
        }


    }
}
