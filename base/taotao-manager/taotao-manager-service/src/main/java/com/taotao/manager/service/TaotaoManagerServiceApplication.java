package com.taotao.manager.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.taotao.common.utils.SpringAppContextUtil;

/**
 * 服务入口
 * @author xiangzuotao
 * @date 2018年1月27日 下午5:05:07
 * @version
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.taotao.manager"})
@EnableJpaRepositories(basePackages = {"com.taotao.manager.repository"})
@MapperScan(basePackages = {"com.taotao.manager.mapper"})
@EntityScan(basePackages = {"com.taotao.manager.entity"})
public class TaotaoManagerServiceApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TaotaoManagerServiceApplication.class, args);
		SpringAppContextUtil.setApplicationContext(context);
	}

}
