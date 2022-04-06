package com.bberzhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @description: Hystrix的主启动类
 * @author: bberzhou@gmail.com
 * @date: 4/3/2022
 * Create By Intellij IDEA
 */
@SpringBootApplication
@EnableEurekaClient
//  开启服务降级需要此注解
@EnableCircuitBreaker
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }
}
