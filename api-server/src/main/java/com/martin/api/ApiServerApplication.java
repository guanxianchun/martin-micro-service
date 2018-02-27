package com.martin.api;

import com.martin.api.filter.AccessTokenFilter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateCustomizer;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenProvider;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 2/22/18 4:18 PM
 * Descrition
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringCloudApplication

public class ApiServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApiServerApplication.class).web(true).run(args);
    }
    @Configuration
//    (SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter{
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/","/**/*.html","/**/*.jsp","/auth-service/**").permitAll()
                    .anyRequest().authenticated().and()
                    .csrf().disable().httpBasic();
//                    csrfTokenRepository(csrfTokenRepository()).and()
//                    .addFilterAfter(csrfHeaderFilter(), SessionManagementFilter.class);
//            http.csrf().disable();
        }

        private Filter csrfHeaderFilter(){
            return new OncePerRequestFilter() {
                @Override
                protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                    CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
                    if (null != csrf){
                        Cookie cookie = WebUtils.getCookie(request,"XSRF-TOKEN");
                        String token = csrf.getToken();
                        if (cookie == null || token !=null && !token.equals(cookie.getValue())){
                            cookie = new Cookie("XSRF-TOKEN",token);
                            cookie.setPath("/");
                            response.addCookie(cookie);
                        }
                    }
                    filterChain.doFilter(request,response);
                }
            };
        }
        private CsrfTokenRepository csrfTokenRepository(){
            HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
            repository.setHeaderName("X-XSRF-TOKEN");
            return repository;
        }
    }

    @Component
//    @Order(Ordered.HIGHEST_PRECEDENCE)
    class WorkAroundRestTemplateCustomizer implements UserInfoRestTemplateCustomizer{
        @Override
        public void customize(OAuth2RestTemplate oAuth2RestTemplate) {
            oAuth2RestTemplate.setInterceptors(oAuth2RestTemplate.getInterceptors());
        }
    }
}
