package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author mingchengtianxia
 * @date 2021/10/31--16:15
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {
	public static void main(String[] args) {
		SpringApplication.run(EurekaMain7002.class,args);
	}
}
