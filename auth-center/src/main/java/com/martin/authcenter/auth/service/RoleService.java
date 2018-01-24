package com.martin.authcenter.auth.service;

import com.martin.authcenter.auth.entity.RoleEntity;

import java.util.List;

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
