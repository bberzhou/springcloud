package com.bberzhou.springcloud.controller;

import com.bberzhou.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 测试 Hystrix 的服务降级
 * @author: bberzhou@gmail.com
 * @date: 4/3/2022
 * Create By Intellij IDEA
 */

@RestController
@Slf4j
@RequestMapping(value = "/consumer/payment")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    /**
     *  消费者端的接口，按照id查询，传入Payment id
     * @param id
     * @return
     */
    @GetMapping(value = "/hystrix/ok/{id}")
    public String  getPaymentById(@PathVariable(value = "id") Integer id){
        return paymentHystrixService.paymentInfoOk(id);
    }

    /**
     *  此接口调用服务端的接口
     * @param id
     * @return
     */
    @GetMapping(value = "/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable(value = "id") Integer id){
        return paymentHystrixService.paymentInfoTimeout(id);
    }
}
