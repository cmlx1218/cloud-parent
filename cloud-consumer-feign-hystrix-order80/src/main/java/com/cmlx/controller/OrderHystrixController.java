package com.cmlx.controller;

import com.cmlx.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: CMLX
 * @Description:
 * @Date: create in 2020/10/27 10:13
 */
@RestController
@RequestMapping("consumer")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/hystrix/ok/{id}")
    String paymentInfo_Ok(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_Ok(id);
        return result;
    }

    @GetMapping("/hystrix/out/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    String paymentInfo_Out(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_Out(id);
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费端80，系统繁忙中...";
    }


}
