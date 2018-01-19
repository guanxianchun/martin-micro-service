package com.martin.euop.user.mapper;

import com.martin.euop.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 2018-01-19 12:50:12
 * Descrition 用户DAO接口
 */
@Mapper
public interface UserMapper {

    public UserEntity getUserById(@Param("userId") String userId);

    public List<UserEntity> getUserByName(@Param("userName") String userName);

}
