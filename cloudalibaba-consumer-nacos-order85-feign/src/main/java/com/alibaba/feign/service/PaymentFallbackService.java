package com.alibaba.feign.service;

import com.bberzhou.springcloud.entities.CommonResult;
import com.bberzhou.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @description: 远程调用统一兜底的方法
 * @author: bberzhou@gmail.com
 * @date: 4/23/2022
 * Create By Intellij IDEA
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回，-------------PaymentFallbackService",new Payment(id,"error"));
    }
}
