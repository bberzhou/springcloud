package com.bberzhou.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: bberzhou@gmail.com
 * @date: 4/3/2022
 * Create By Intellij IDEA
 */
@Service
public class PaymentService {
    /**
     *  正常访问ok 的方法
     * @param id
     * @return
     */
    public String paymentInfoOk(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentInfoOk，id："+id+"\t";
    }

    /**
     *
     * ===========================服务降级============================
     *  服务降级可以用在服务端，但是通常消费端来做服务降级，服务端做服务熔断
     * 这个服务端的方法，设置自身调用超时时间的峰值，峰值内可以正常运行
     * 超过了需要又兜底的方法进行处理，做一个服务降级的fallback
     *
     *  @HystrixCommand 注解，就是当前服务如果不可用的时候，需要fallback方法
     *
     *  一旦调用服务方法失败并抛出错误信息之后，会自动调用@HystrixCommand 注解中标注好的fallbackMethod调用类中的指定方法
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",
            // 这个注解表示当前线程的超时阈值是 3000 ms，如果超过就执行fallback里面的方法

            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    public String paymentInfoTimeout(Integer id){
        int timeNumber = 1;
        // 内部如果有异常，也会有兜底的方法
        // int age = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+" paymentInfoTimeout，id："+id+"\t"+"耗时："+timeNumber;
    }

    public String paymentInfoTimeoutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentInfoTimeoutHandler，id："+id+"\t"+"8001服务暂停";
    }


    //================================服务熔断======================================================

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败率达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
            //  当在快照时间窗口期m内请求次数n中有60% 的失败率就会达到服务熔断
            //  熔断打开：请求不再进行调用当前服务，内部设置时钟一般为MTTR（平均故障处理时间），当打开时长达到所设时钟则进入半熔断状态
            //  熔断关闭：熔断关闭不会对服务进行熔断
            //  熔断半开：部分请求根据规则调用当前服务，如果请求成功且符合规则就认为当前服务回复正常，关闭熔断
    })
    public String paymentCircuitBreaker(@PathVariable(value = "id") Integer id){
        if (id < 0){
            throw new RuntimeException("**************id 不能为负数" );

        }
        // IdUtil.simpleUUID() == UUID.randomUUID().toString()
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;

    }

    public String paymentCircuitBreakerFallback(@PathVariable(value = "id") Integer id){
        return "id 不能为负数，请稍后再试+ id"+id;
    }
}
