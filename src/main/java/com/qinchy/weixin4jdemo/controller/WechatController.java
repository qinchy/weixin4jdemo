package com.qinchy.weixin4jdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.weixin4j.Configuration;
import org.weixin4j.spi.HandlerFactory;
import org.weixin4j.spi.IMessageHandler;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/WechatServlet")
public class WechatController {
    private Logger log = LoggerFactory.getLogger(WechatController.class);

    @RequestMapping(method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/xml");
            //获取POST流
            ServletInputStream in = request.getInputStream();
            if (Configuration.isDebug()) {
                log.debug("接收到微信输入流,准备处理...");
            }

            //处理输入消息，返回结果
            IMessageHandler messageHandler = HandlerFactory.getMessageHandler();
            //处理输入消息，返回结果
            String xml = messageHandler.invoke(in);
            //String xml = "<a>a</a>";
            //返回结果
            response.getWriter().write(xml);
        } catch (Exception ex) {
            log.error("doPost出错", ex);
        }
    }

}

