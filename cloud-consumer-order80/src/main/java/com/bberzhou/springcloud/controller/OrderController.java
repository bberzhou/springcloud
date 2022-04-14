package com.bberzhou.springcloud.controller;

import com.bberzhou.springcloud.entities.CommonResult;
import com.bberzhou.springcloud.entities.Payment;
import com.bberzhou.springcloud.loadbalance.MyLoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @description:
 * @author: bberzhou@gmail.com
 * @date: 3/31/2022
 * Create By Intellij IDEA
 */
@RestController
@Slf4j
public class OrderController {
    // 这里不能把URL写死，因为有多个服务提供者
    // public static final String PAYMENT_URL = "http://localhost:8001";
    // public static final String PAYMENT_SRV = "http://CLOUD-PAYMENT-SERVICE";
    // public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;
    /**
     *  配置服务发现
     */
    @Resource
    private DiscoveryClient discoveryClient;


    /**
     *  引入自定义的轮询
     */
    @Resource
    private MyLoadBalance myLoadBalance;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable(value = "id") Long id){
        log.info("消费者端进行：。。。。。。。。。");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    /**
     *
     *  P37 RestTemplate 详细讲解
     *
     *  getForEntity和postForObject的区别
     *
     *  getForEntity：返回对象为响应体中数据转化乘的对象，基本上可以看成是JSON串
     *  postForObject：返回对象为ResponseEntity对象，包含了响应中的一些重要信息，比如响应头、响应状态码、响应体等等
     *
     *
     */
    @GetMapping(value = "/consumer/payment/getForEntiry/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable(value = "id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.getStatusCode()+"\t"+entity.getStatusCodeValue());
            return entity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败");
        }
    }


    /**
     *
     * @return
     */
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <=0){
            return null;
        }
        ServiceInstance serviceInstance = myLoadBalance.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);

    }

    @GetMapping(value = "/consumer/payment/zipkin")
    public String paymentZipkin(){
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/",String.class);
        return result;
    }
}