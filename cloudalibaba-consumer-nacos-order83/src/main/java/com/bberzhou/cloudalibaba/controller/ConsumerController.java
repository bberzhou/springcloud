package com.bberzhou.cloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description: 消费者的Controller
 * @author: bberzhou@gmail.com
 * @date: 4/15/2022
 * Create By Intellij IDEA
 */

@RestController
public class ConsumerController {
    // 从配置文件获取请求路径

    @Value("${service-url.nacos-user-service}")
    private String url;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") String id){
      return restTemplate.getForObject(url+"/payment/nacos/"+id, String.class);
    }
}
