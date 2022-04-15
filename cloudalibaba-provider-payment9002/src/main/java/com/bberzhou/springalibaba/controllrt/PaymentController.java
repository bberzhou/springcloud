package com.bberzhou.springalibaba.controllrt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 9002的controller
 * @author: bberzhou@gmail.com
 * @date: 4/15/2022
 * Create By Intellij IDEA
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    /**
     *  测试Nacos的服务注册功能，
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") String  id){
        return "nacos registry, serverport:"+serverPort+"\t"+id;
    }
}
