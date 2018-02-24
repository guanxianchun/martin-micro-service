package com.martin.euop.user.service;

import com.martin.euop.user.entity.UserEntity;

import java.util.List;
/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 2018-01-19 12:50:12
 * Descrition 用户服务接口
 */
public interface UserService {
    /**
     * 通过用户ID查询用户信息
     * @param userId
     * @return
     */
    public UserEntity getUserById(String userId);

    /**
     * 通过用户名查询用户信息
     * @param userName
     * @return
     */
    public List<UserEntity> getUserByName(String userName);

    /**
     * 测试获取用户的授权　负载均衡(ribbon)　熔断器(hystrix)　
     * @param userId
     * @return
     */
    public String getUserLicense(String userId);
}
