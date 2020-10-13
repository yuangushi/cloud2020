package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Transactional
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [id]
     * @Return: com.atguigu.springcloud.entities.Payment
     * @Author: Administrator
     * @Date: 2020/10/9 11:40
     */
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
