package com.bberzhou.sentinel.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bberzhou.springcloud.entities.CommonResult;
import com.bberzhou.springcloud.entities.Payment;

/**
 * @description: 自定义的限流处理类，可以避免每一个业务代码都去写一个兜底的方法
 * @author: bberzhou@gmail.com
 * @date: 4/23/2022
 * Create By Intellij IDEA
 */

public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception){
        return new CommonResult(444,"按照统一的自定义兜底的方法,global-------------1",new Payment(2020L,"serial2022"));
    }
    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(444,"按照统一的自定义兜底的方法,global-------------2",new Payment(2020L,"serial2022"));
    }
}
