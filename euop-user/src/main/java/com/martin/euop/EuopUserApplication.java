package com.martin.euop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EuopUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(EuopUserApplication.class, args);
	}
}
