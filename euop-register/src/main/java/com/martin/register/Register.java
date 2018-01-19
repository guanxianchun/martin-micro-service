package com.martin.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 2018-01-19 12:50:12
 * Descrition　注册服务
 */
@EnableEurekaServer
@SpringBootApplication
public class Register {

	public static void main(String[] args) {
		SpringApplication.run(Register.class, args);
	}
}
