package com.bberzhou.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description: 分布式组件之间的调用
 * @author: bberzhou@gmail.com
 * @date: 3/31/2022
 * Create By Intellij IDEA
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    // 这个注解表示开启负载均衡机制，这样就能够根据微服务提供的 服务名 CLOUD-PAYMENT-SERVICE ，自动去映射
    // Ribbon和Eureka 整合之后Consumer可以直接调用服务而不再关心地址和端口号，且该服务还有负载功能，采用轮询算法进行调用
    //  如果使用自定义的规则，就需要把这个注解去掉
    // @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
