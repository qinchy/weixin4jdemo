package com.qinchy.weixin4jdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "hello", path = "/hello")
public class HelloController {

    private Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET)
    public String greeting(@PathVariable String name) {
        log.info("receive pathvariable [name] = " + name);
        return "hello:" + name;
    }
}
