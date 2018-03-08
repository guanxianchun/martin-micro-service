package com.martin.euop.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 2/22/18 4:18 PM
 * Descrition
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableOAuth2Sso
public class ApiServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApiServerApplication.class).web(true).run(args);
    }
}
