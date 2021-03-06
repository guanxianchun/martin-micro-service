package com.martin.euop.authcenter.auth.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.martin.euop.authcenter.auth.entity.UserEntity;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 2018-01-23 3:12 PM
 * Descrition 
 */
@Mapper
public interface UserDao {
    /**
     *
     * @param userName
     * @return
     */
    public UserEntity findByUserName(@Param("userName") String userName);

    /**
     *
     * @param userId
     * @return
     */
    public UserEntity findByUserId(String userId);
}
