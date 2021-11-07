package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author mingchengtianxia
 * @date 2021/11/6--17:24
 */
@Service
public class PaymentService {

	public String paymentInfo_OK(Integer id){
		return "线程池："+Thread.currentThread().getName()+" paymentInfo_OK,id: "+"\t"+"O(∩_∩)O哈哈~";
	}

	public String paymentInfo_TimeOut(Integer id){
		int timeNum = 3;
		try{
			TimeUnit.SECONDS.sleep(timeNum);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		return "线程池："+Thread.currentThread().getName()+" paymentInfo_TimeOut,id: "+"\t"+"耗时:"+timeNum;
	}
}
