package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mingchengtianxia
 * @date 2021/11/4--21:34
 */

@RestController
@Slf4j
public class OrderFeignController {

	@Resource
	private PaymentFeignService paymentFeignService;

	@GetMapping(value = "/consumer/payment/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){
		return paymentFeignService.getPaymentById(id);
	}

	@GetMapping(value = "/consumer/payment/feign/timeout")
	public String paymentFeignTimeout(){
		// 默認等待1秒
		return paymentFeignService.paymentFeignTimeout();
	}
}
