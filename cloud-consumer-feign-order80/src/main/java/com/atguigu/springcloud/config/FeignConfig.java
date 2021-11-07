package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mingchengtianxia
 * @date 2021/11/6--11:02
 */

@Configuration
public class FeignConfig {

	@Bean
	Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}
}
