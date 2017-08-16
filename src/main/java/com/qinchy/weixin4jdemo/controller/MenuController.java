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
@RequestMapping(path = "/menu")
public class MenuController {

    private Logger log = LoggerFactory.getLogger(MenuController.class);

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public String get() {
        return WeixinRequestUtils.request(WeixinUrlEnum.Menu.GET, null,"JSON");
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String create(String body) {
        if (StringUtils.isBlank(body)) {
            return "菜单body为空";
        }

        try{
            JSONObject.fromObject(body);
        }catch (Exception e){
            log.error("菜单文本不是合法的json串", e);
        }

        return WeixinRequestUtils.request(WeixinUrlEnum.Menu.CREATE, body, "JSON");
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String delete() {
        return WeixinRequestUtils.request(WeixinUrlEnum.Menu.DELETE, null, "JSON");
    }
}
