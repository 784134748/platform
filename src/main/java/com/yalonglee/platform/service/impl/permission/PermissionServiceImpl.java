package com.yalonglee.platform.service.impl.permission;

import com.yalonglee.platform.dao.permission.PermissionDaoI;
import com.yalonglee.platform.entity.permission.Permission;
import com.yalonglee.platform.service.permission.PermissionServiceI;
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
public class PermissionServiceImpl implements PermissionServiceI {
    @Autowired
    private PermissionDaoI permissionDaoI;

    @Override
    public Permission get(Serializable id) {
        return permissionDaoI.get(id);
    }

    @Override
    public Set<String> getPermissionsByUid(Serializable id) {
        String hql = "select p.permission from User u inner join u.roles r inner join r.permissions p where u.id = ? ";
        List<String> permissions = permissionDaoI.getParamsByHql(hql, id);
        Set<String> result = new HashSet<>(16);
        result.addAll(permissions);
        return result;
    }

    @Override
    public void saveOrUpdate(Permission permission) {
        permissionDaoI.saveOrUpdate(permission);
    }

    @Override
    public void delete(Permission permission) {
        permissionDaoI.delete(permission);
    }

}
