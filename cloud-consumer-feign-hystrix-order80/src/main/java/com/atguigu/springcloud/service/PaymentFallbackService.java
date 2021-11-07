package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author mingchengtianxia
 * @date 2021/11/7--12:22
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService {
	@Override
	public String paymentInfo_OK(Integer id) {
		return "---PaymentFallbackService fall back paymentInfo_OK --";
	}

	@Override
	public String paymentInfo_timeout(Integer id) {
		return "---PaymentFallbackService fall back paymentInfo_timeout --";

	}
}
