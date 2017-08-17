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
@RequestMapping(path = "/material")
public class MaterialController {

    private Logger log = LoggerFactory.getLogger(MaterialController.class);

    @RequestMapping(path = "/addNews",method = RequestMethod.POST)
    public String addNews(String body){
        if (StringUtils.isBlank(body)) {
            return "客服消息体为空";
        }

        try{
            JSONObject.fromObject(body);
        }catch (Exception e){
            log.error("客服消息体不是合法的json串", e);
            return "客服消息体不是合法的json串";
        }
        return WeixinRequestUtils.request(WeixinUrlEnum.MATERIAL_ADDNEWS, body, "JSON");
    }
}
