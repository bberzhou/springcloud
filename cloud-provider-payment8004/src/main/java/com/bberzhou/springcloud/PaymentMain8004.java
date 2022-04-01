package com.bberzhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description: zookeeper的主启动类
 * @author: bberzhou@gmail.com
 * @date: 4/1/2022
 * Create By Intellij IDEA
 */
@SpringBootApplication
// 该注解用于向consul或者zookeeper作为注册中心的时候注册服务
@EnableDiscoveryClient
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
