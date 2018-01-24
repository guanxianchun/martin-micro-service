package com.martin.authserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/24/18 1:07 PM
 * Descrition 配置用户信息、以及受保护路径、允许访问路径
 */
@Configuration
public class WebOAuthSecurityConfig extends WebSecurityConfigurerAdapter{
    @Resource
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/*.ico");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
        UserDetails userDetails = userDetailsService().loadUserByUsername("guanxianchun");
        System.out.println(userDetails.getPassword());
    }
}
