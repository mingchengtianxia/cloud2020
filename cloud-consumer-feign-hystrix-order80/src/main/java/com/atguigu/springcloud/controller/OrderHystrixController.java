package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mingchengtianxia
 * @date 2021/11/7--11:05
 *
 * @DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
 * 通用的fallback 服务降级
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {

	@Resource
	private PaymentHystrixService paymentHystrixService;

	@GetMapping("/consumer/payment/hystrix/ok/{id}")
	public String paymentInfo_OK(@PathVariable("id") Integer id){
		String infoOk = paymentHystrixService.paymentInfo_OK(id);
		log.info("consumer payment isok**"+id);
		return infoOk;
	}

	@GetMapping("/consumer/payment/hystrix/timeout/{id}")
//	@HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties ={
//			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//	} )
	@HystrixCommand
	public String paymentInfo_timeout(@PathVariable("id") Integer id){
		String s = paymentHystrixService.paymentInfo_timeout(id);
		log.info("consumer timeout id"+id);
		return s;
	}

	public String paymentInfoTimeOutHandler(@PathVariable("id") Integer id){
		return "我是消费者80，对方支付系统繁忙或者自己运行出错，o(╥﹏╥)o";
	}

	//全局fallback
	public String paymentGlobalFallbackMethod(){
		return "Global信息异常，请稍后再试，o(╥﹏╥)o";
	}

}
