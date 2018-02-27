package com.martin.euop.authcenter.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.euop.authcenter.auth.dao.RoleDao;
import com.martin.euop.authcenter.auth.entity.RoleEntity;
import com.martin.euop.authcenter.auth.service.RoleService;

import java.util.List;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/23/18 3:29 PM
 * Descrition
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<RoleEntity> findRoleByUserId(String userId) {
        return roleDao.findRoleByUserId(userId);
    }
}
