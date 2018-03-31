package com.yalonglee.platform.service.impl.permission;

import com.yalonglee.platform.dao.permission.GroupDaoI;
import com.yalonglee.platform.entity.permission.*;
import com.yalonglee.platform.service.permission.GroupServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
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
public class GroupServiceImpl implements GroupServiceI {
    @Autowired
    private GroupDaoI groupDaoI;

    @Override
    public Set<User> getUsersByResourceId(Serializable groupId) {
        return null;
    }

    @Override
    public Set<Role> getRolesByResourceId(Serializable groupId) {
        return null;
    }

    @Override
    public Set<Permission> getPermissionsByResourceId(Serializable groupId) {
        return null;
    }

    @Override
    public Set<Resource> getResourcesByGroupId(Serializable groupId) {
        return null;
    }

    @Override
    public Group get(Serializable id) {
        return groupDaoI.get(id);
    }

    @Override
    public void save(Group user) {
        groupDaoI.save(user);
    }

    @Override
    public void update(Group user) {
        groupDaoI.update(user);
    }

    @Override
    public void saveOrUpdate(Group user) {
        groupDaoI.saveOrUpdate(user);
    }

    @Override
    public void delete(Group user) {
        groupDaoI.delete(user);
    }
}
