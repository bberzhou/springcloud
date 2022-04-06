package com.bberzhou.springcloud.service;

import com.bberzhou.springcloud.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description: 通过Feign来进行微服务调用，配置相关的接口
 * @author: bberzhou@gmail.com
 * @date: 4/3/2022
 * Create By Intellij IDEA
 */
@Component
// 为当前接口，设置统一的fallback方法，避免在每一个controller里面吗去写
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",configuration = FeignConfig.class, fallback = PaymentHystrixServiceImpl.class)
public interface PaymentHystrixService {
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable(value = "id") Integer id);
    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    String paymentInfoTimeout(@PathVariable(value = "id") Integer id);

}
