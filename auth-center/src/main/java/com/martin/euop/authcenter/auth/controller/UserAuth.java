package com.martin.euop.authcenter.auth.controller;/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/19/18 4:46 PM
 * Descrition
 */

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 2018-01-19 4:46 PM
 * Descrition 必须有　做验证用
 */

@RestController
public class UserAuth {
    @RequestMapping(value = "/user")
    public Principal user(Principal user){
        return user;
    }
}
