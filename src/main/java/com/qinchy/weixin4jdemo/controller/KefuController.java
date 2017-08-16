package com.qinchy.weixin4jdemo.controller;

import com.qinchy.weixin4jdemo.common.WeixinRequestUtils;
import com.qinchy.weixin4jdemo.common.WeixinUrlEnum;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/kefu")
public class KefuController {

    private Logger log = LoggerFactory.getLogger(KefuController.class);

    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public String add(String body){
        if (StringUtils.isBlank(body)) {
            return "客服消息体为空";
        }

        try{
            JSONObject.fromObject(body);
        }catch (Exception e){
            log.error("客服消息体不是合法的json串", e);
            return "客服消息体不是合法的json串";
        }

        return WeixinRequestUtils.request(WeixinUrlEnum.KEFU_ADD, body,"JSON");
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public String update(String body){
        if (StringUtils.isBlank(body)) {
            return "客服消息体为空";
        }

        try{
            JSONObject.fromObject(body);
        }catch (Exception e){
            log.error("客服消息体不是合法的json串", e);
            return "客服消息体不是合法的json串";
        }

        return WeixinRequestUtils.request(WeixinUrlEnum.KEFU_UPDATE, body,"JSON");
    }

    @RequestMapping(path = "/del",method = RequestMethod.POST)
    public String del(String body){
        if (StringUtils.isBlank(body)) {
            return "客服消息体为空";
        }

        try{
            JSONObject.fromObject(body);
        }catch (Exception e){
            log.error("客服消息体不是合法的json串", e);
            return "客服消息体不是合法的json串";
        }
        return WeixinRequestUtils.request(WeixinUrlEnum.KEFU_DELETE, body,"JSON");
    }

    @RequestMapping(path = "/getkflist",method = RequestMethod.GET)
    public String getkflist(){
        return WeixinRequestUtils.request(WeixinUrlEnum.KEFU_LIST, null,"JSON");
    }

}
