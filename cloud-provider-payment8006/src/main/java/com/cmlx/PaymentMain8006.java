package com.cmlx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: CMLX
 * @Description:
 * @Date: create in 2020/10/26 12:08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class,args);
        System.out.println("Consul服务提供者8006启动成功！！！");
    }

}
