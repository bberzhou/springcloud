package com.bberzhou.springcloud.service.Impl;

import com.bberzhou.springcloud.dao.PaymentDao;
import com.bberzhou.springcloud.entities.Payment;
import com.bberzhou.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: bberzhou@gmail.com
 * @date: 3/30/2022
 * Create By Intellij IDEA
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
