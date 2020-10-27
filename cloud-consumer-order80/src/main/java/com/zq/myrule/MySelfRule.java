package com.zq.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: CMLX
 * @Description: 自定义负载均衡规则【不要放在@ComponentScan的包下，主启动类就有这个包】
 * @Date: create in 2020/10/26 16:06
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        return new RandomRule();
    }

}
