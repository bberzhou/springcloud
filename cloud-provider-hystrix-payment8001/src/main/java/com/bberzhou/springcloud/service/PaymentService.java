package com.bberzhou.springcloud.service;

import org.springframework.stereotype.Service;

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

    public String paymentInfoTimeout(Integer id){
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+" paymentInfoTimeout，id："+id+"\t"+"耗时："+timeNumber;
    }

}
