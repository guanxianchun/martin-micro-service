package com.martin.euop.authcenter.auth.service;

import java.util.List;

import com.martin.euop.authcenter.auth.entity.MenuEntity;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/23/18 3:26 PM
 * Descrition
 */
public interface PrivilegeService {
    /**
     *
     * @param roleId
     * @return
     */
    public List<MenuEntity> findPrivilegeByRoleId(Integer roleId);
}
