package com.atguigu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author mingchengtianxia
 * @date 2021/11/21--10:08
 */

@Component
@Slf4j
public class MyGatewayFilter implements GlobalFilter,Ordered{
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("*** com in MyLogGatewayFilter:"+new Date());
		String uname = exchange.getRequest().getQueryParams().getFirst("uname");
		if(uname == null){
			log.info("**********用户名为null，非法用户");
			exchange.getResponse().setStatusCode(HttpStatus.NO_CONTENT);
			return exchange.getResponse().setComplete();
		}
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
