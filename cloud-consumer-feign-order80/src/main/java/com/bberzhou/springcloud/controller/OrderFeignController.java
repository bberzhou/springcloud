package com.bberzhou.springcloud.controller;

import com.bberzhou.springcloud.entities.CommonResult;
import com.bberzhou.springcloud.entities.Payment;
import com.bberzhou.springcloud.service.PaymentFeignService;
import feign.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: bberzhou@gmail.com
 * @date: 4/2/2022
 * Create By Intellij IDEA
 */
@RestController
@Slf4j
public class OrderFeignController {
    /**
     *  controller 直接注入PaymentService;
     */
    @Resource
    private PaymentFeignService paymentService;

    /**
     *  消费者端的接口，按照id查询，传入Payment id
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable(value = "id") Long id){
        return paymentService.getPaymentById(id);
    }


    /**
     *  测试 openFeign的超时控制
     * @return
     */
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        // openFeign->底层还是基于ribbon，客户端默认一般等待1秒钟
        String s = paymentService.paymentFeignTimeout();
        return s;

    }
}
