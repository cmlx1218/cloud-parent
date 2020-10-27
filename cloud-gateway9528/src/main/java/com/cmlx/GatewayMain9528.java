package com.cmlx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: CMLX
 * @Description:
 * @Date: create in 2020/10/27 18:24
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9528 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9528.class,args);
        System.out.println("网关服务9528启动成功！！！");
    }

}
