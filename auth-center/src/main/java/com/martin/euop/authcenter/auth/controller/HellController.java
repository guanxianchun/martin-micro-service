package com.martin.euop.authcenter.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/24/18 2:31 PM
 * Descrition
 */
@RestController
public class HellController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    public String hell(){
        return "hello";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public void doLogin(String userName,String password){
        System.out.println(userName);
    }
}
