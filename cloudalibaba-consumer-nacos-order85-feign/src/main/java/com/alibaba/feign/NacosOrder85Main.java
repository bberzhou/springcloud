package com.alibaba.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description: 消费者 85的主启动类
 * @author: bberzhou@gmail.com
 * @date: 4/23/2022
 * Create By Intellij IDEA
 */
@SpringBootApplication
// 开启feign
@EnableFeignClients
@EnableDiscoveryClient
public class NacosOrder85Main {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrder85Main.class,args);
    }
}
