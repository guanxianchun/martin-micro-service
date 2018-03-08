package com.martin.euop.authcenter.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.martin.euop.authcenter.auth.entity.MenuEntity;
import com.martin.euop.authcenter.auth.entity.RoleEntity;
import com.martin.euop.authcenter.auth.entity.UserEntity;
import com.martin.euop.authcenter.auth.service.PrivilegeService;
import com.martin.euop.authcenter.auth.service.RoleService;
import com.martin.euop.authcenter.auth.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author 管贤春
 * Email psyche19830113@163.com
 * Date 1/24/18 1:44 PM
 * Descrition
 */
@Service
public class EuopUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PrivilegeService privilegeService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByUserName(userName);
        if (userEntity == null){
            throw  new UsernameNotFoundException("user :"+userName+" not exists");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        boolean enabled = true; //可用性　
        boolean isExpired = false;  //是否过期
        boolean credentialExpired = false;  //有效性　
        boolean isLocked = false;   //锁定性　true :锁定　
        List<RoleEntity> roles = roleService.findRoleByUserId(userEntity.getUserId());
        System.out.println("user "+userName+" has privileges :");
        for(RoleEntity roleEntity:roles){
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+roleEntity.getName());
            authorities.add(authority);
            //get role permission
            List<MenuEntity> privilegeEntities = privilegeService.findPrivilegeByRoleId(roleEntity.getId());
            
            for (MenuEntity menuEntity : privilegeEntities){
            	System.out.println(menuEntity.getCode());
                GrantedAuthority menuAuthority = new SimpleGrantedAuthority(menuEntity.getCode());
                authorities.add(menuAuthority);
            }
        }
        User user = new User(userEntity.getUserName(),userEntity.getPassword(),enabled,!isExpired,!credentialExpired,!isLocked,authorities);
        return user;
    }
}
