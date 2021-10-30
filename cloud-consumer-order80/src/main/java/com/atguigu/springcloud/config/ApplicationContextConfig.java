package com.atguigu.springcloud.config;


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
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
