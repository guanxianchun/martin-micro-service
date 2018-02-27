package com.martin.euop.authcenter.auth.service;

import java.util.List;

import com.martin.euop.authcenter.auth.entity.RoleEntity;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/23/18 3:25 PM
 * Descrition
 */
public interface RoleService {
    /**
     *
     * @param userId
     * @return
     */
    public List<RoleEntity> findRoleByUserId(String userId);
}
