package com.martin.euop.user.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 2018-01-19 12:50:12
 * Descrition 用户实体类
 */
public class UserEntity implements Serializable {
    //
    private String userId;
    private String userName;
    private Integer userType;
    private String description;
    private Integer age;
    private String phone;
    private String address;
    private Date createTime;

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

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
