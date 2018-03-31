package com.yalonglee.platform.service.impl.permission;

import com.yalonglee.platform.dao.permission.ResourceDaoI;
import com.yalonglee.platform.dao.permission.ResourceDaoI;
import com.yalonglee.platform.entity.permission.*;
import com.yalonglee.platform.entity.permission.Resource;
import com.yalonglee.platform.service.permission.ResourceServiceI;
import com.yalonglee.platform.service.permission.ResourceServiceI;
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
public class ResourceServiceImpl implements ResourceServiceI {
    @Autowired
    private ResourceDaoI resourceDaoI;

    @Override
    public Set<User> getUsersByResourceId(Serializable resourceId) {
        return null;
    }

    @Override
    public Set<Role> getRolesByResourceId(Serializable resourceId) {
        return null;
    }

    @Override
    public Set<Group> getGroupsByResourceId(Serializable resourceId) {
        return null;
    }

    @Override
    public Set<Permission> getPermissionsByResourceId(Serializable resourceId) {
        return null;
    }

    @Override
    public Resource get(Serializable id) {
        return resourceDaoI.get(id);
    }

    @Override
    public void save(Resource resource) {
        resourceDaoI.save(resource);
    }

    @Override
    public void update(Resource resource) {
        resourceDaoI.update(resource);
    }

    @Override
    public void saveOrUpdate(Resource resource) {
        resourceDaoI.saveOrUpdate(resource);
    }

    @Override
    public void delete(Resource resource) {
        resourceDaoI.delete(resource);
    }
}
