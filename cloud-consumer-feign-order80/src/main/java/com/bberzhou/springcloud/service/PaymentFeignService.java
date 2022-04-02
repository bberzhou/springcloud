package com.bberzhou.springcloud.service;

import com.bberzhou.springcloud.config.FeignConfig;
import com.bberzhou.springcloud.entities.CommonResult;
import com.bberzhou.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @author: bberzhou@gmail.com
 * @date: 4/2/2022
 * Create By Intellij IDEA
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",configuration = FeignConfig.class)
public interface PaymentFeignService {
    /**
     *  这里的方法声明跟8001service中的一样
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();
}
