package com.bberzhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @description: SpringCloud config 的主启动类
 * @author: bberzhou@gmail.com
 * @date: 4/8/2022
 * Create By Intellij IDEA
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    /**
     *  测试通过Config微服务是否可以从Github上获取配置内容
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}
