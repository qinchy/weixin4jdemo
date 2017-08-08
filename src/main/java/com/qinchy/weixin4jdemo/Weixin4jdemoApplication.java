package com.qinchy.weixin4jdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan
@MapperScan(value = "com.qinchy.weixin4jdemo.dao")
public class Weixin4jdemoApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Weixin4jdemoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Weixin4jdemoApplication.class, args);
    }
}
