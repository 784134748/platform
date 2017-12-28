package com.iflytek.operation.service.impl.permission;

import com.iflytek.operation.dao.permission.PermissionDaoI;
import com.iflytek.operation.dao.permission.RoleDaoI;
import com.iflytek.operation.dao.permission.UserDaoI;
import com.iflytek.operation.entity.permission.Permission;
import com.iflytek.operation.entity.permission.User;
import com.iflytek.operation.service.permission.PermissionServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/14]
 * @see [相关类/方法]
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PermissionServiceImpl implements PermissionServiceI {
    @Autowired
    private UserDaoI userDaoI;
    @Autowired
    private RoleDaoI roleDaoI;
    @Autowired
    private PermissionDaoI permissionDaoI;

    @Override
    public void saveOrUpdate(Permission permission) {
        permissionDaoI.saveOrUpdate(permission);
    }

    @Override
    public User getUserByUsername(String username) {
        String hql = "from User where username = ?";
        return userDaoI.getEntityByHql(hql, username);
    }

    @Override
    public Set<String> getRolesByUid(Long id) {
        String hql = "select r.role from User u left join u.roles r where u.id = ? ";
        List<String> roles = roleDaoI.getParamsByHql(hql,id);
        Set<String> result = new HashSet<>(16);
        result.addAll(roles);
        return result;
    }

    @Override
    public Set<String> getPermissionsByUid(Long id) {
        String hql = "select p.permission from User u left join u.roles r left join r.permissions p where u.id = ? ";
        List<String> permissions = permissionDaoI.getParamsByHql(hql,id);
        Set<String> result = new HashSet<>(16);
        result.addAll(permissions);
        return result;
    }

}
