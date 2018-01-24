package com.martin.authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import java.util.Arrays;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/24/18 10:31 AM
 * Descrition
 */
@EnableAuthorizationServer
@SpringBootApplication
public class AuthServerApplication {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class,args);
    }

    @Bean
    public AuthenticationManager authenticationManager(){
        return new ProviderManager(Arrays.asList(authenticationProvider));
    }
}
