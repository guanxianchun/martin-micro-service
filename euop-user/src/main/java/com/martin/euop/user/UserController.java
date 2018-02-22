package com.martin.euop.user;

import com.martin.euop.message.LocaleMessageSourceService;
import com.martin.euop.user.service.UserService;
import com.martin.euop.user.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private DiscoveryClient client;

    @Autowired
    private UserService userService;

    @Resource
    private LocaleMessageSourceService localeMessageSourceService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String getUsers(HttpServletRequest httpRequest){
        ServiceInstance instance = client.getLocalServiceInstance();
        System.out.println(localeMessageSourceService.getMessage("euop.user.login_name",RequestContextUtils.getLocale(httpRequest)));
        logger.info("/users, host : "+instance.getHost()+" service instance id : "+instance.getServiceId());
        return "Hello World !";
    }
    @ResponseBody
    @RequestMapping(value = "/users/{userId}",method = RequestMethod.GET)
    public UserEntity getUserInfo(HttpServletRequest httpRequest,@PathVariable("userId") String userId){
        System.out.println(localeMessageSourceService.getMessage("euop.user.login_name",new Object[]{"gxc"},RequestContextUtils.getLocale(httpRequest)));
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/users/"+userId+", host : "+instance.getHost()+" service instance id : "+instance.getServiceId()+" userId="+userId);
        UserEntity userInfo = userService.getUserById(userId);
        return userInfo;
    }
    @ResponseBody
    @RequestMapping(value = "/users/{userId}/licenseInfo",method = RequestMethod.GET)
    public String getUserLicenseInfo(){
        return restTemplate.getForEntity("http://EUOP-LICENSE/licenseInfo",String.class).getBody();
    }
}
