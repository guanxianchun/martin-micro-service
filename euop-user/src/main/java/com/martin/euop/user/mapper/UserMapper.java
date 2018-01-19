package com.martin.euop.user.mapper;

import com.martin.euop.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    public UserEntity getUserById(@Param("userId") String userId);

    public List<UserEntity> getUserByName(@Param("userName") String userName);

}
