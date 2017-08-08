package com.qinchy.weixin4jdemo.schedule;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.weixin4j.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

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

        String accessToken = null;
        InputStream is = null;

        try {
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();

            http.setRequestMethod("GET"); // 必须是get方式请求
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒

            http.connect();
            is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);

            String message = new String(jsonBytes, "UTF-8");
            JSONObject demoJson = JSONObject.fromObject(message);
            accessToken = demoJson.getString("access_token");

            if (Configuration.isDebug()) {
                log.debug("access_token = " + accessToken);
            }

            setAccessToken(accessToken);

            is.close();

        } catch (UnsupportedEncodingException e) {
            log.error("不支持的编码", e);
        } catch (ProtocolException e) {
            log.error("不支持的协议", e);
        } catch (MalformedURLException e) {
            log.error("不支持的编码", e);
        } catch (IOException e) {
            log.error("读取流信息出错", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                log.error("关闭流信息出错", e);
            }
        }
    }

}
