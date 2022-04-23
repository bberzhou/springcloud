package com.alibaba.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bberzhou.springcloud.entities.CommonResult;
import com.bberzhou.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description:
 * @author: bberzhou@gmail.com
 * @date: 4/23/2022
 * Create By Intellij IDEA
 */
@RestController
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    /**
     *  一、未配置@SentinelResource的时候
     *  如果程序有异常的话，会直接 返回报错信息到前台，不太友好，
     * @param id
     * @return
     */
    // @RequestMapping(value = "/consumer/fallback/{id}")
    // @SentinelResource(value = "fallback")
    // public CommonResult<Payment> fallback(@PathVariable(value = "id") Long id){
    //     CommonResult commonResult = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
    //     if (id == 4){
    //         throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常..........");
    //     }else if (commonResult.getData() ==null){
    //         throw new NullPointerException("NullPointerException，该id没有对应的记录，空指针异常");
    //     }
    //     return commonResult;
    // }


    /**
     *  二、配置@SentinelResource的兜底，只负责业务异常时
     *   这个时候，类似hystrix 的服务降级处理
     * @param id
     * @return
     */
    // @RequestMapping(value = "/consumer/fallback/{id}")
    // @SentinelResource(value = "fallback",fallback = "handlerFallback")
    // public CommonResult<Payment> fallback(@PathVariable(value = "id") Long id){
    //     CommonResult commonResult = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
    //     if (id == 4){
    //         throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常..........");
    //     }else if (commonResult.getData() ==null){
    //         throw new NullPointerException("NullPointerException，该id没有对应的记录，空指针异常");
    //     }
    //     return commonResult;
    // }
    // public CommonResult handlerFallback(@PathVariable(value = "id") Long id, Throwable e){
    //     Payment payment = new Payment(id, "null");
    //     return new CommonResult(444,"兜底异常handlerFallback, exception内容"+e.getMessage(),payment);
    // }

    /**
     *
     * 三、只配置blockHandler的情况，
     *  blockHandler 只是负责 sentinel控制台里面配置的相关规则
     *  这个时候，如果id 是 5 或者大于4的会发生什么情况呢？===》会将报错的空白信息输出到前端
     *
     *  但是如果在sentinel里面进行相关的配置操作，如果满足那个配置要求，就会走sentinel中配置的blockHandler兜底方法
     *
     *
     * @param id
     * @return
     */
    // @RequestMapping(value = "/consumer/fallback/{id}")
    // @SentinelResource(value = "fallback", blockHandler = "blockHandler")
    // public CommonResult<Payment> fallback(@PathVariable(value = "id") Long id){
    //     CommonResult commonResult = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
    //     if (id == 4){
    //         throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常..........");
    //     }else if (commonResult.getData() ==null){
    //         throw new NullPointerException("NullPointerException，该id没有对应的记录，空指针异常");
    //     }
    //     return commonResult;
    // }

    // public CommonResult blockHandler(@PathVariable(value = "id") Long id, BlockException e){
    //     Payment payment = new Payment(id, "null");
    //     return new CommonResult(444,"blockHandler-sentinel 限流，无此流水,BlockException内容"+e.getMessage(),payment);
    // }


    /**
     *  四、两个都配置的情况， blockHandler 和 handlerFallback
     *  则被限流降级而抛出BlockException时只会进入到blockHandler处理逻辑
     * @param id
     * @return
     */
    // @RequestMapping(value = "/consumer/fallback/{id}")
    // @SentinelResource(value = "fallback", fallback = "handlerFallback",blockHandler = "blockHandler")
    // public CommonResult<Payment> fallback(@PathVariable(value = "id") Long id){
    //     CommonResult commonResult = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
    //     if (id == 4){
    //         throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常..........");
    //     }else if (commonResult.getData() ==null){
    //         throw new NullPointerException("NullPointerException，该id没有对应的记录，空指针异常");
    //     }
    //     return commonResult;
    // }
    // public CommonResult handlerFallback(@PathVariable(value = "id") Long id, Throwable e){
    //     Payment payment = new Payment(id, "null");
    //     return new CommonResult(444,"兜底异常handlerFallback, exception内容"+e.getMessage(),payment);
    // }
    // public CommonResult blockHandler(@PathVariable(value = "id") Long id, BlockException e){
    //     Payment payment = new Payment(id, "null");
    //     return new CommonResult(444,"blockHandler-sentinel 限流，无此流水,BlockException内容"+e.getMessage(),payment);
    // }


    /**
     *  五、忽略属性
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",
            fallback = "handlerFallback",
            blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable(value = "id") Long id){
        CommonResult commonResult = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4){
            throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常..........");
        }else if (commonResult.getData() ==null){
            throw new NullPointerException("NullPointerException，该id没有对应的记录，空指针异常");
        }
        return commonResult;
    }
    public CommonResult handlerFallback(@PathVariable(value = "id") Long id, Throwable e){
        Payment payment = new Payment(id, "null");
        return new CommonResult(444,"兜底异常handlerFallback, exception内容"+e.getMessage(),payment);
    }
    public CommonResult blockHandler(@PathVariable(value = "id") Long id, BlockException e){
        Payment payment = new Payment(id, "null");
        return new CommonResult(444,"blockHandler-sentinel 限流，无此流水,BlockException内容"+e.getMessage(),payment);
    }
}
