package com.martin.authcenter.auth.dao;

import com.martin.authcenter.auth.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

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
