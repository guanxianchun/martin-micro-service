package com.martin.authcenter.auth.dao;

import com.martin.authcenter.auth.entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/23/18 3:22 PM
 * Descrition
 */
@Mapper
public interface PrivilegeDao {
    /**
     *
     * @param roleId
     * @return
     */
    public List<MenuEntity> findPrivilegeByRoleId(Integer roleId);

}
