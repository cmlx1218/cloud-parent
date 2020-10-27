package com.cmlx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: CMLX
 * @Description:
 * @Date: create in 2020/10/26 11:06
 */
@RestController
@RequestMapping("consumer")
public class OrderZkController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";


    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/payment/zk")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }


}
