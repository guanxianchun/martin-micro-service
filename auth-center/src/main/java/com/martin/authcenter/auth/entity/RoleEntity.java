package com.martin.authcenter.auth.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 2018-01-23 2:48 PM
 * Descrition 用户角色实体类
 */
public class RoleEntity implements Serializable {

    private int id;

    private String name;

    private String description;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
