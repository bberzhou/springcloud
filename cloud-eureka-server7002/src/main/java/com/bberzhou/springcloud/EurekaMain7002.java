package com.bberzhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description: 配置7002 eureka服务端主启动类
 * @author: bberzhou@gmail.com
 * @date: 4/1/2022
 * Create By Intellij IDEA
 */
@SpringBootApplication
// 开启EurekaServer
@EnableEurekaServer
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class, args);
    }
}
