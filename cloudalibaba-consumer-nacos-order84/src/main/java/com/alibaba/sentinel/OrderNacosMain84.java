package com.alibaba.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description: 消费者84的主启动类， 配置Ribbon和nacos+sentinel，来进行远程调用的相关操作
 * @author: bberzhou@gmail.com
 * @date: 4/23/2022
 * Create By Intellij IDEA
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacosMain84 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain84.class,args);
    }
}
