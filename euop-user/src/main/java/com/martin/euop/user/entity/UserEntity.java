package com.martin.euop.user.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {
    //
    private String userId;
    private String userName;
    private Integer userDeptId;
    private Integer userType;
    private Integer userPlatform;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserDeptId() {
        return userDeptId;
    }

    public void setUserDeptId(Integer userDeptId) {
        this.userDeptId = userDeptId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserPlatform() {
        return userPlatform;
    }

    public void setUserPlatform(Integer userPlatform) {
        this.userPlatform = userPlatform;
    }
}
