package com.martin.euop.authcenter.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.euop.authcenter.auth.dao.PrivilegeDao;
import com.martin.euop.authcenter.auth.entity.MenuEntity;
import com.martin.euop.authcenter.auth.service.PrivilegeService;

import java.util.List;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/23/18 3:30 PM
 * Descrition
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    @Autowired
    private PrivilegeDao privilegeDao;
    @Override
    public List<MenuEntity> findPrivilegeByRoleId(Integer roleId) {
        return privilegeDao.findPrivilegeByRoleId(roleId);
    }
}
