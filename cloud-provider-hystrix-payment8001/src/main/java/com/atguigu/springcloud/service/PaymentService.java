package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author mingchengtianxia
 * @date 2021/11/6--17:24
 */
@Service
public class PaymentService {

	public String paymentInfo_OK(Integer id){
		return "线程池："+Thread.currentThread().getName()+" paymentInfo_OK,id: "+id+"\t"+"O(∩_∩)O哈哈~";
	}

	@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties ={
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
	} )
	public String paymentInfo_TimeOut(Integer id){
		int timeNum = 1;
//		int age = 10/0;
		try{
			TimeUnit.SECONDS.sleep(timeNum);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		return "线程池："+Thread.currentThread().getName()+" paymentInfo_TimeOut,id: "+id+"\t"+"耗时:"+timeNum;
	}

	public String paymentInfo_TimeOutHandler(Integer id){
		return "线程池："+Thread.currentThread().getName()+" 系统繁忙，稍后再试,id: "+id+"\t"+"o(╥﹏╥)o";
	}
}
