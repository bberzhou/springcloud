package com.bberzhou.cloudalibaba.conig;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description: 消费者端的配置类
 * @author: bberzhou@gmail.com
 * @date: 4/15/2022
 * Create By Intellij IDEA
 */
@RestController
public class ApplicationContextConfig {
    @Bean
    // 配置负载均衡，因为nacod 默认配置类ribbon 所以需要开启负载均衡
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
