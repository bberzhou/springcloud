package com.bberzhou.springalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description: 9002的主启动类
 * @author: bberzhou@gmail.com
 * @date: 4/15/2022
 * Create By Intellij IDEA
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaPaymentMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaPaymentMain9002.class,args);
    }
}
