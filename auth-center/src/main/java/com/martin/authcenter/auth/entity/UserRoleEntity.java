package com.martin.authcenter.auth.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 2018-01-23 2:55 PM
 * Descrition 
 */
public class UserRoleEntity implements Serializable {
    private Integer id;

    private String userId;

    private Integer roleId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
