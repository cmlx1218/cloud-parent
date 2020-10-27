package com.cmlx.controller;

import com.cmlx.entities.CommonResult;
import com.cmlx.entities.Payment;
import com.cmlx.service.IPaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: CMLX
 * @Description:
 * @Date: create in 2020/10/26 18:23
 */
@RestController
@RequestMapping("consumer")
public class OrderFeignController {

    @Resource
    private IPaymentService iPaymentService;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return iPaymentService.getPaymentById(id);
    }

    @GetMapping("/feign/timeout")
    public String PaymentFeignTimeout() {
        // openFeign-ribbon,客户端一般默认等待1s
        return iPaymentService.PaymentFeignTimeout();
    }
}
