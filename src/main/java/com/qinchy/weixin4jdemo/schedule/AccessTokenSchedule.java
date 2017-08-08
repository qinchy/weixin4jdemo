package com.qinchy.weixin4jdemo.schedule;

import com.qinchy.weixin4jdemo.common.HttpUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.weixin4j.Configuration;

public class AccessTokenSchedule {

    private Logger log = LoggerFactory.getLogger(AccessTokenSchedule.class);

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

    @Scheduled(cron = "0 0 0/1 * * ? ")
    public void retrieveAccessToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                + Configuration.getProperty("weixin4j.oauth.appid") + "&secret=" + Configuration.getProperty("weixin4j.oauth.secret");

        String accessToken = HttpUtils.get(url, null, "UTF-8");

        if (Configuration.isDebug()) {
            log.debug("access_token = " + accessToken);
        }

        setAccessToken(accessToken);
    }

}
