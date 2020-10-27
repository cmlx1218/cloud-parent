package com.cmlx.controller;

import com.cmlx.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: CMLX
 * @Description:
 * @Date: create in 2020/10/27 9:53
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    //==========> 服务降级
    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_Ok(id);
        log.info("*****result：" + result);
        return result;
    }

    @GetMapping("/hystrix/out/{id}")
    public String paymentInfo_Out(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_Out(id);
        log.info("*****result：" + result);
        return result;
    }

    //==========> 服务熔断
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*****result：" + result);
        return result;
    }


}
