package com.yalonglee.platform.service.impl.permission;

import com.yalonglee.platform.dao.permission.RoleDaoI;
import com.yalonglee.platform.entity.permission.*;
import com.yalonglee.platform.service.permission.RoleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/14]
 * @see [相关类/方法]
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleServiceI {
    @Autowired
    private RoleDaoI roleDaoI;

    @Override
    public Set<User> getUsersByRoleId(Serializable roleId) {
        return null;
    }

    @Override
    public Set<Group> getGroupsByRoleId(Serializable roleId) {
        return null;
    }

    @Override
    public Set<Permission> getPermissionsByRoleId(Serializable roleId) {
        return null;
    }

    @Override
    public Set<Resource> getResourcesByRoleId(Serializable roleId) {
        return null;
    }

    @Override
    public Role get(Serializable id) {
        return roleDaoI.get(id);
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        String hql = "from Role r where r.role = ？ ";
        List<Role> roles = roleDaoI.getParamsByHql(hql,roleName );
        return roles.size()>0 ? roles.get(0) : null;
    }

    @Override
    public Set<String> getRolesByUid(Serializable id) {
        String hql = "select r.role from User u inner join u.roles r where u.id = ? ";
        List<String> roles = roleDaoI.getParamsByHql(hql, id);
        Set<String> result = new HashSet<>(16);
        result.addAll(roles);
        return result;
    }

    @Override
    public void saveOrUpdate(Role role) {
        roleDaoI.saveOrUpdate(role);
    }

    @Override
    public void delete(Role role) {
        roleDaoI.delete(role);
    }
}
