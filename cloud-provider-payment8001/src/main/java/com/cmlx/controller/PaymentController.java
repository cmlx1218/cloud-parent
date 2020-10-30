package com.cmlx.controller;

import com.cmlx.entities.CommonResult;
import com.cmlx.entities.Payment;
import com.cmlx.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: CMLX
 * @Description:
 * @Date: create in 2020/10/22 15:51
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private IPaymentService iPaymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment) {
        Integer result = iPaymentService.create(payment);
        log.info("****插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功，serverPort=" + serverPort, result);
        } else {
            return new CommonResult(500, "插入数据库失败，serverPort=" + serverPort, null);
        }
    }

    @GetMapping(value = "/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = iPaymentService.getPaymentById(id);
        log.info("****查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询数据库成功，serverPort=" + serverPort, payment);
        } else {
            return new CommonResult(500, "查询数据库失败，serverPort=" + serverPort, null);
        }
    }

    @GetMapping(value = "getDiscovery")
    public Object getDiscovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("******element: " + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String getPaymentLb() {
        return serverPort;
    }

    @GetMapping("/feign/timeout")
    public String PaymentFeignTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return serverPort;
    }

    @GetMapping("zipkin")
    public String paymentZipkin() {
        return "hi,I'm paymentzipkin!!!";
    }


}
