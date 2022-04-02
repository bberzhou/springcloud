package com.bberzhou.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: 具体轮询的实现类
 * @author: bberzhou@gmail.com
 * @date: 4/2/2022
 * Create By Intellij IDEA
 */
@Component
public class MyLoadBalance implements LoadBalancer{
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
            // 获取当前的值
            current = this.atomicInteger.get();
            // 这里使用的自旋锁
            next = current >= Integer.MAX_VALUE ? 0 :  current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("第几次访问，次数next"+next);
        return next;
    }
    // 负载均衡算法：restController 接口第几次请数 % 服务器集群总数量 = 实际调用服务器位置下标，每次服务重启后rest接口计数从0开始

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
