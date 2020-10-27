package com.cmlx.service;

import com.cmlx.entities.CommonResult;
import com.cmlx.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: CMLX
 * @Description:
 * @Date: create in 2020/10/26 18:19
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface IPaymentService {

    @GetMapping(value = "/payment/getPaymentById/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/feign/timeout")
    String PaymentFeignTimeout();

}
