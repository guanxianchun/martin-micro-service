package com.martin.euop.authcenter.auth.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 2018-01-23 3:04 PM
 * Descrition 角色权限实体类
 */
public class PrivilegeEntity implements Serializable{

    private Integer roleId;

    private String menuId;

    private Date createTime;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
