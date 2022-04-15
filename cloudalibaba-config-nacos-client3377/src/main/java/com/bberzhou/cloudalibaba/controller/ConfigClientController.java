package com.bberzhou.cloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 配置类的controller
 * @author: bberzhou@gmail.com
 * @date: 4/15/2022
 * Create By Intellij IDEA
 */
@RestController
// 这个注解表示支持Nacos得动态刷新功能，能够实现配置文件的自动更新
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/config/info")
    public String getConfigInfo(){
        return configInfo;
    }

}
