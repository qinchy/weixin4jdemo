package com.qinchy.weixin4jdemo.filter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.weixin4j.Configuration;
import org.weixin4j.util.TokenUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "WeixinFilter", urlPatterns = "/WechatServlet")
public class WeixinFilter implements Filter {

    private Logger log = LoggerFactory.getLogger(WeixinFilter.class);

    @Override
    public void init(FilterConfig config) throws ServletException {
        if (Configuration.isDebug()) {
            log.debug("WeixinUrlFilter启动成功!");
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        boolean isGet = request.getMethod().toLowerCase().equals("get");

        if (Configuration.isDebug()) {
            log.debug("获得微信请求:" + request.getMethod() + " 方式");
            log.debug("微信请求URL:" + request.getServletPath());
        }
        //消息来源可靠性验证
        String signature = StringUtils.defaultIfEmpty(request.getParameter("signature"), "");// 微信加密签名
        String timestamp = StringUtils.defaultIfEmpty(request.getParameter("timestamp"), "");// 时间戳
        String nonce = StringUtils.defaultIfEmpty(request.getParameter("nonce"), "");       // 随机数

        //Token为weixin4j.properties中配置的Token
        String token = TokenUtil.get();

        if (isGet) {
            String echostr = StringUtils.defaultIfEmpty(request.getParameter("echostr"), "");   //

            //确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
            if (TokenUtil.checkSignature(token, signature, timestamp, nonce)) {
                response.getWriter().write(echostr);
            } else {
                //消息不可靠，直接返回
                response.getWriter().write("invalid request");
            }
        } else {
            if (TokenUtil.checkSignature(token, signature, timestamp, nonce)) {
                chain.doFilter(req, res);
            } else {
                //消息不可靠，直接返回
                response.getWriter().write("invalid request");
            }

        }
    }

    @Override
    public void destroy() {
    }
}
