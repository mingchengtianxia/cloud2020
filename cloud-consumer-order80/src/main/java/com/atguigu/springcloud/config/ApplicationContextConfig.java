package com.atguigu.springcloud.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author mingchengtianxia
 * @date 2021/10/30--20:46
 */

@Configuration
public class ApplicationContextConfig {

	@Bean
	@LoadBalanced    //赋予Rest负载均衡的能力
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
