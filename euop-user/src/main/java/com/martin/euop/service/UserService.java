package com.martin.euop.service;

import com.martin.euop.user.entity.UserEntity;

import java.util.List;

public interface UserService {

    public UserEntity getUserById(String userId);

    public List<UserEntity> getUserByName(String userName);
}
