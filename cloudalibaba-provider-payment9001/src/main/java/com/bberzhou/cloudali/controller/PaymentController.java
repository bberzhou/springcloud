package com.bberzhou.cloudali.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 服务提高的Controller
 * @author: bberzhou@gmail.com
 * @date: 4/15/2022
 * Create By Intellij IDEA
 */
@RestController
public class PaymentController {
    /**
     *  获取端口号
     */
    @Value("${server.port}")
    private String serverPort;
    /**
     *  测试Nacos的服务注册功能，
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") String id){
        System.out.println(id);
        return "nacos registry, serverport:"+serverPort+"\t"+id;
    }
}
