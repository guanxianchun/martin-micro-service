package com.martin.authcenter.auth.service;

import com.martin.authcenter.auth.entity.UserEntity;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/23/18 3:24 PM
 * Descrition
 */
public interface UserService {

    public UserEntity findByUserName(String userName);

}
