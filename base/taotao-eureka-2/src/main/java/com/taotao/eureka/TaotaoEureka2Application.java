package com.taotao.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka 启动入口
 * @author xiangzuotao
 * @date 2018年1月27日 下午2:23:52
 * @version
 */
@SpringBootApplication
@EnableEurekaServer
public class TaotaoEureka2Application {

	public static void main(String[] args) {
		SpringApplication.run(TaotaoEureka2Application.class, args);
	}

}
