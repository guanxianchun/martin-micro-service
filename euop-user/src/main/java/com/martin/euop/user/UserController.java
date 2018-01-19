package com.martin.euop.user;

import com.martin.euop.user.service.UserService;
import com.martin.euop.user.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private DiscoveryClient client;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String getUsers(){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/users, host : "+instance.getHost()+" service instance id : "+instance.getServiceId());
        return "Hello World !";
    }
    @ResponseBody
    @RequestMapping(value = "/users/{userId}",method = RequestMethod.GET)
    public UserEntity getUserInfo(@PathVariable("userId") String userId){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/users/"+userId+", host : "+instance.getHost()+" service instance id : "+instance.getServiceId()+" userId="+userId);
        UserEntity userInfo = userService.getUserById(userId);
        return userInfo;
    }

}
