package com.bberzhou.springcloud.controller;

import com.bberzhou.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
// 当前这个controller的全局通用fallback
@DefaultProperties(defaultFallback = "PaymentGlobalFallbackMethod")
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
     *  此接口调用服务端的接口，注意一般就是在客户端开启服务降级，当服务不可用时，要有一个兜底的解决方案
     * @param id
     * @return
     */
    @GetMapping(value = "/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod",
            // 这里设置超时阈值为 1.5秒，如果超过就需要调用兜底的方法
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "4000")})
    // @HystrixCommand
    public String paymentInfoTimeout(@PathVariable(value = "id") Integer id){
        int age = 10 /0;
        return paymentHystrixService.paymentInfoTimeout(id);
    }

    public String paymentTimeoutFallbackMethod(@PathVariable("id") Integer id){
        return "消费端 80，对方支付系统繁忙，请稍后再试。。。。。。。。。。。。。。。";
    }


    /**
     *  为了减少代码的冗余，编写一个通用的降级方法,如果需要单独定义的，还是可以通过注解进行定制化处理
     *  如果有些需要单独配置，还是可以通过注解 @HystrixCommand+ 指定方法名进行处理。
     * @return
     */
    public String PaymentGlobalFallbackMethod(){
        return "Global 异常信息，请稍后再试。。。。。。。。。";
    }
}
