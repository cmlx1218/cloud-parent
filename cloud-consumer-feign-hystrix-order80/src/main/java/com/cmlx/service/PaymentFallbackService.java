package com.cmlx.service;

import org.springframework.stereotype.Component;

/**
 * @Author: CMLX
 * @Description:
 * @Date: create in 2020/10/27 11:31
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "------PaymentFallbackService fall back-->paymentInfo_Ok,|||||||||||";
    }

    @Override
    public String paymentInfo_Out(Integer id) {
        return "------PaymentFallbackService fall back-->paymentInfo_Out,|||||||||||";
    }
}
