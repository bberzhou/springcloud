package com.alibaba.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description: 微服务提供者9004的主启动类
 * @author: bberzhou@gmail.com
 * @date: 4/23/2022
 * Create By Intellij IDEA
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9004.class,args);
    }
}
