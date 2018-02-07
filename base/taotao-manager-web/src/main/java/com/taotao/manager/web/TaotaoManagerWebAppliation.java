package com.taotao.manager.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 表现层入口
 * @author xiangzuotao
 * @date 2018年1月27日 下午4:08:53
 * @version
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@ComponentScan(basePackages = {"com.tatotao"})
public class TaotaoManagerWebAppliation {

	public static void main(String[] args) {
		SpringApplication.run(TaotaoManagerWebAppliation.class, args);
	}

}
