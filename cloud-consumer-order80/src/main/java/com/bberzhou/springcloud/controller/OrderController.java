package com.bberzhou.springcloud.controller;

import com.bberzhou.springcloud.entities.CommonResult;
import com.bberzhou.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description:
 * @author: bberzhou@gmail.com
 * @date: 3/31/2022
 * Create By Intellij IDEA
 */
@RestController
@Slf4j
public class OrderController {
    // 这里不能把URL写死，因为有多个服务提供者
    // public static final String PAYMENT_URL = "http://localhost:8001";
    // public static final String PAYMENT_SRV = "http://CLOUD-PAYMENT-SERVICE";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable(value = "id") Long id){
        log.info("消费者端进行：。。。。。。。。。");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
