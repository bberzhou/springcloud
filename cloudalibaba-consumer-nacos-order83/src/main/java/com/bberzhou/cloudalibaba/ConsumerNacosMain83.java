package com.bberzhou.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description: nacos消费者主启动类
 * @author: bberzhou@gmail.com
 * @date: 4/15/2022
 * Create By Intellij IDEA
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerNacosMain83 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerNacosMain83.class,args);
    }
}
