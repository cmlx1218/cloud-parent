package com.cmlx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: CMLX
 * @Description:
 * @Date: create in 2020/10/26 12:17
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/consul")
    public String paymentConsul() {
        return "Spring Cloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
