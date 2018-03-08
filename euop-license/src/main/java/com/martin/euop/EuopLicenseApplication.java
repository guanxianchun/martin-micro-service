package com.martin.euop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 2/22/18 11:14 AM
 * Descrition
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EuopLicenseApplication {

    public static void main(String[] args) {
        SpringApplication.run(EuopLicenseApplication.class,args);
    }
}
