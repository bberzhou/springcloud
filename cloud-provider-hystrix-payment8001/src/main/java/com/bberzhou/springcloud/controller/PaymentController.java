package com.bberzhou.springcloud.controller;

import com.bberzhou.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: bberzhou@gmail.com
 * @date: 4/3/2022
 * Create By Intellij IDEA
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    // ===========================服务降级的相关测试=============================

    @GetMapping(value = "/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable(value = "id") Integer id){

        String s = paymentService.paymentInfoOk(id);
        log.info("++++++++++++++++++++++++result:"+s);
        return s;
    }
    @GetMapping(value = "/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable(value = "id") Integer id){

        String s = paymentService.paymentInfoTimeout(id);
        log.info("++++++++++++++++++++++++result:"+s);
        return s;
    }

    //  ========================服务熔断的相关测试=================================
    @GetMapping(value = "/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable(value = "id") Integer id){
        String s = paymentService.paymentCircuitBreaker(id);
        log.info("==================result"+s);
        return s;
    }
}
