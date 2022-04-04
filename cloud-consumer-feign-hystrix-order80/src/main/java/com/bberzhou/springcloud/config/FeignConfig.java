package com.bberzhou.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: Feign的配置类，对日志等进行配置
 * @author: bberzhou@gmail.com
 * @date: 4/2/2022
 * Create By Intellij IDEA
 */
@Configuration
public class FeignConfig {
    /**
     *  配置Feign的日志级别
     *  openFeign的日志级别及其配置
     *  NONE：默认的，不显示任何日志
     *  BASIC：仅记录请求方法、URL、响应状态码和执行时间
     *  HEADERS：除了BASIC中定义的信息之外，还有请求和响应的头信息，
     *  FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文以及元数据
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){

        return Logger.Level.FULL;
    }
}
