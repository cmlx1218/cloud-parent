package com.cmlx.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: CMLX
 * @Description:
 * @Date: create in 2020/10/26 9:46
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "zk")
    public String paymentZk() {
        return "SpringCloud whit zookeeper: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
