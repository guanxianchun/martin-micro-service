package com.martin.euop.authcenter.auth.config;

import org.springframework.boot.autoconfigure.security.Http401AuthenticationEntryPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/24/18 2:21 PM
 * Descrition 开启资源服务
 */
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(new Http401AuthenticationEntryPoint("bearer realm=\"webrealm\""))
                .and().authorizeRequests().anyRequest().authenticated()
                .and().httpBasic();
    }
}
