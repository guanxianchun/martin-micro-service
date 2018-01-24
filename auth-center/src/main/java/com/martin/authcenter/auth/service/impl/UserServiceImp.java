package com.martin.authcenter.auth.service.impl;

import com.martin.authcenter.auth.dao.UserDao;
import com.martin.authcenter.auth.entity.UserEntity;
import com.martin.authcenter.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/23/18 3:27 PM
 * Descrition
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }
}
