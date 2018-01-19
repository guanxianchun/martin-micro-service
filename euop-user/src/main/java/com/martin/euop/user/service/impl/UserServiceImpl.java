package com.martin.euop.user.service.impl;

import com.martin.euop.user.service.UserService;
import com.martin.euop.user.entity.UserEntity;
import com.martin.euop.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserEntity> getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

    @Override
    public UserEntity getUserById(String userId) {
        return userMapper.getUserById(userId);
    }
}
