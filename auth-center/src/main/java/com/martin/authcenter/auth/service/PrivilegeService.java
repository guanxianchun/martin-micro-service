package com.martin.authcenter.auth.service;

import com.martin.authcenter.auth.entity.MenuEntity;

import java.util.List;

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
