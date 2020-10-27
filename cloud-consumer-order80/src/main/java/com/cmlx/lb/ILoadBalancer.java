package com.cmlx.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author: CMLX
 * @Description:
 * @Date: create in 2020/10/26 16:37
 */
public interface ILoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
