package com.bberzhou.springcloud.controller;

import com.bberzhou.springcloud.entities.CommonResult;
import com.bberzhou.springcloud.entities.Payment;
import com.bberzhou.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: bberzhou@gmail.com
 * @date: 3/30/2022
 * Create By Intellij IDEA
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    /**
     * 服务端口，从配置文件读取
     */
    @Value("${server.port}")
    private String serverPort;

    /**
     *  配置服务发现
     */
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Object> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果。。。。。。"+result);
        if (result > 0){
            return  new CommonResult(200,"插入数据库成功！serverPort"+serverPort,result);
        }else {
            return new CommonResult(404,"插入数据失败！",null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("按照id查询的结果。。。。。。"+payment);
        if (payment != null){
            return  new CommonResult(200,"查询成功！serverPort："+serverPort,payment);
        }else {
            return new CommonResult(404,"查询失败！",null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service: services){
            log.info("*********************service*********"+service);
        }
        // 还可以通过服务Id获取
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : instances){
            log.info("************************instance****"+serviceInstance.getServiceId()+"\t"
                    +serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
        }
        return this.discoveryClient;
    }
}
