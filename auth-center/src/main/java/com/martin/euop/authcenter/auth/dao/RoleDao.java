package com.martin.euop.authcenter.auth.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import com.martin.euop.authcenter.auth.entity.RoleEntity;

import java.util.List;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/23/18 3:17 PM
 * Descrition
 */
@Mapper
public interface RoleDao {
    /**
     *
     * @param userId
     * @return
     */
    public List<RoleEntity> findRoleByUserId(String userId);

}
