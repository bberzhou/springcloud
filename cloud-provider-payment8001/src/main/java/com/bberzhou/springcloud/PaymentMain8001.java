package com.bberzhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description: 支付服务主启动类
 * @author: bberzhou@gmail.com
 * @date: 3/30/2022
 * Create By Intellij IDEA
 */
@SpringBootApplication
@EnableEurekaClient
// 添加服务发现注解
@EnableDiscoveryClient
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
    }
}
