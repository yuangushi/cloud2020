package com.atguigu.springcloud.web;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
public class OrderController {
    //现在需要调用的是服务提供者的数据，该怎么去获取服务者的注入呢
    //目前还没有eureka,所以先用restTemplate

    private static final String PAYMENT_URL="http://localhost:8001";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    @ResponseBody
    public CommonResult<Payment> create(Payment payment){
        log.info("消费者创建数据:"+payment);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    @ResponseBody
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("消费者查询，ID是："+id);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
