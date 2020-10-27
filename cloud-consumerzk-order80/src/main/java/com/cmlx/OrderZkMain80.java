package com.cmlx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: CMLX
 * @Description:
 * @Date: create in 2020/10/26 10:57
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain80 {

    public static void main(String[] args) {

        SpringApplication.run(OrderZkMain80.class,args);
        System.out.println("Zookeeper服务消费端OrderZk80启动成功！！！");

    }

}
