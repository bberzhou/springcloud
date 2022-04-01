package com.bberzhou.springcloud.service;

import com.bberzhou.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: bberzhou@gmail.com
 * @date: 3/30/2022
 * Create By Intellij IDEA
 */
public interface PaymentService {
    /**
     *  创建支付记录
     * @param payment 支付实体
     * @return
     */
    int create(Payment payment);

    /**
     *  通过id 查询
     * @param id 支付id
     * @return 返回一个支付对象
     */
    Payment getPaymentById(@Param("id") Long id);
}
