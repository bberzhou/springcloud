package com.bberzhou.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @description: 测试zookeeper
 * @author: bberzhou@gmail.com
 * @date: 4/1/2022
 * Create By Intellij IDEA
 */
@Slf4j
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentZk(){
        return "spring cloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID();
    }
}
