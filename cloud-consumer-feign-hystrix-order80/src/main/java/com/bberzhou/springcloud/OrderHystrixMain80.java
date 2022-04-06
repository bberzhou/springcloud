package com.bberzhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description: 消费端，配置Hystrix主启动类
 * @author: bberzhou@gmail.com
 * @date: 4/3/2022
 * Create By Intellij IDEA
 */
@SpringBootApplication
// 并使用Feign
@EnableFeignClients
// 开启Hystrix的支持
@EnableCircuitBreaker
public class OrderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class, args);
    }
}
