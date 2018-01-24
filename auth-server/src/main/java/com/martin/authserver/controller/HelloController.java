package com.martin.authserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/24/18 1:14 PM
 * Descrition
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello")
    public String hello(){
        return "Hello World";
    }
}
