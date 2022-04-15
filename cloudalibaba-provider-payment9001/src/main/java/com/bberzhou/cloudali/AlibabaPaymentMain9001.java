package com.bberzhou.cloudali;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description: cloud alibaba  服务提供者主启动类
 * @author: bberzhou@gmail.com
 * @date: 4/15/2022
 * Create By Intellij IDEA
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaPaymentMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaPaymentMain9001.class,args);
    }
}
