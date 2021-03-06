package com.qinchy.weixin4jdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.qinchy.weixin4jdemo.common.WeixinRequestUtils;
import com.qinchy.weixin4jdemo.common.WeixinUrlEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/card")
public class CardController {

    private Logger log = LoggerFactory.getLogger(CardController.class);

    @RequestMapping(path = "/createcard",method = RequestMethod.POST)
    public String createCard(String body){
        if (StringUtils.isBlank(body)) {
            return "卡券消息体为空";
        }

        try{
            JSONObject.parseObject(body);
        }catch (Exception e){
            log.error("卡券消息体不是合法的json串", e);
            return "卡券消息体不是合法的json串";
        }

        return WeixinRequestUtils.request(WeixinUrlEnum.CARD_CREATE, body,"JSON");
    }

    @RequestMapping(path = "/createQrcode",method = RequestMethod.POST)
    public String createQrcode(String body){
        if (StringUtils.isBlank(body)) {
            return "卡券消息体为空";
        }

        try{
            JSONObject.parseObject(body);
        }catch (Exception e){
            log.error("卡券消息体不是合法的json串", e);
            return "卡券消息体不是合法的json串";
        }

        return WeixinRequestUtils.request(WeixinUrlEnum.QRCODE_CREATE, body,"JSON");
    }
}
