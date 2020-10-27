package com.cmlx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: CMLX
 * @Description:
 * @Date: create in 2020/10/26 18:14
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
        System.out.println("Feign服务消费端90服务启动成功！！！");
    }

}
