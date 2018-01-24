package com.martin.authserver.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collections;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/24/18 10:37 AM
 * Descrition
 */
@Configuration
public class EuopAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //返回一个token对象表示登录成功
        return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),authentication.getCredentials(), Collections.< GrantedAuthority>emptyList());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
