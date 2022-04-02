package com.bberzhou.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @description: 自定义轮询算法
 * @author: bberzhou@gmail.com
 * @date: 4/2/2022
 * Create By Intellij IDEA
 */
public interface LoadBalancer {
    /**
     *  获取所有的Service
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
