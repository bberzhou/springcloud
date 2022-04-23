package com.bberzhou.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bberzhou.sentinel.myhandler.CustomerBlockHandler;
import com.bberzhou.springcloud.entities.CommonResult;
import com.bberzhou.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 测试SentinelResource注解相关
 * @author: bberzhou@gmail.com
 * @date: 4/23/2022
 * Create By Intellij IDEA
 */
@RestController
@Slf4j
public class RateLimitController {
    /**
     * 通过 注解 @SentinelResource(value = "byResource",blockHandler = "handleException")
     * 按照资源名称进行流控规则配置，并且自定义相关的兜底方法，如果按照资源名配置，不自定义兜底的方法就会报错
     * com.alibaba.csp.sentinel.slots.block.flow.FlowException: null
     *
     * @return
     */
    @GetMapping("/byResource")
    // 这里注解配置之后，可以在控制台--》流控规则--》新增流控规则--》按照资源名进行配置
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试ok", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException blockException) {
        // 返回自定义得限流信息
        return new CommonResult(444, blockException.getClass().getCanonicalName() + "\t" + "服务不可用");

    }

    /**
     *  按照url进行配置，没有指定兜底的方法，这时就会使用自带的兜底方法
     * @return
     */
    @GetMapping(value = "/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按照url限流测试ok", new Payment(2020L, "serial2002"));
    }


    /**
     *  这里主要是通过自定义的 CustomerBlockHandler 类里面，的兜底方法进行处理，
     * @return
     */
    @GetMapping(value = "/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException2")
    public CommonResult customerBlockHandler(){
     return new CommonResult(200,"按照自定义的返回",new Payment(2020L,"serial003"));
    }
}
