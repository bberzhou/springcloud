package com.bberzhou.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @description: 为PaymentHystrixService编写一个统一的兜底类
 * @author: bberzhou@gmail.com
 * @date: 4/4/2022
 * Create By Intellij IDEA
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService{

    /**
     *  当服务端的8001不可用时，可能就会出现客户端访问不到的情况，这时就需要做一个服务降级的处理，保证系统能够正常运行
     *  为了方便解耦，可以写一个类，来实现 带有@FeignClient 注解的接口，指定这个接口里面所有方法的fallbackMethod
     *
     *  哪些情况会触发服务降级呢？
     *      1、程序运行时异常
     *      2、程序运行的时候，超时了，（例如在8001中设置的服务请求时间）
     *      3、服务熔断触发服务加ing及
     *      4、线程池或者信号量打满也会导致服务降级
     *
     *      服务的降级----> 进而熔断----> 恢复调用熔断
     *
     *      熔断机制：
     *          1、熔断机制是应对雪崩效应的一种微服务链路保护机制，当扇出链路的某个微服务出错不可用或者响应时间太长时，
     *             会进行服务的降级，进而熔断该节点微服务的调用，快速返回错误的响应信息。
     *
     *             同时，当检测到该节点微服务调用响应正常后，恢复调用链路
     *
     *          2、在Spring Cloud 框架里面，熔断机制可以通过Hystrix实现，Hystrix会监控微服务间调用的状况，
     *             当失败的调用到一定的阈值，默认是5秒内20次调用失败，就会启动熔断机制，熔断机制的注解是@Hystrixcommand
     *
     *
     *
     *
     * @param id
     * @return
     */
    @Override
    public String paymentInfoOk(Integer id) {
        return "------------------PaymentFallbackService fall back paymentInfoOk ";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "------------------------- paymentInfoTimeout fall back";
    }
}
