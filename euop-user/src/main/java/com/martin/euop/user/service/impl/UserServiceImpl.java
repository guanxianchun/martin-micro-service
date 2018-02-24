package com.martin.euop.user.service.impl;

import com.martin.euop.message.LocaleMessageSourceService;
import com.martin.euop.user.service.UserService;
import com.martin.euop.user.entity.UserEntity;
import com.martin.euop.user.mapper.UserMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<UserEntity> getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

    @HystrixCommand(fallbackMethod = "userLicenseFallback")
    public String getUserLicense(String userId) {
        return restTemplate.getForEntity("http://EUOP-LICENSE/licenseInfo?userId="+userId,String.class).getBody();
    }

    public String userLicenseFallback(String userId){
        return "error";
    }
    @Override
    public UserEntity getUserById(String userId) {
        return userMapper.getUserById(userId);
    }
}
