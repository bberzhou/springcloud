package com.alibaba.feign.controller;

import com.alibaba.feign.service.PaymentService;
import com.bberzhou.springcloud.entities.CommonResult;
import com.bberzhou.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: bberzhou@gmail.com
 * @date: 4/23/2022
 * Create By Intellij IDEA
 */
@RestController
public class CircleController {

    /**
     *  openFeign 远程调用 nacos-payment-provider
     *
     */

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable(value = "id") Long id){
        return paymentService.paymentSQL(id);
    }
}
