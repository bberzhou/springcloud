package com.bberzhou.springcloud;

import com.bberzhou.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @description: 消费者模块的主启动类
 * @author: bberzhou@gmail.com
 * @date: 3/31/2022
 * Create By Intellij IDEA
 */
@SpringBootApplication
@EnableEurekaClient

// 修改了负载规则之后，需要在主启动类上，添加上注解
// 需要的服务名称以及自定义规则配置类
// @RibbonClient(name = "cloud-payment-service",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
