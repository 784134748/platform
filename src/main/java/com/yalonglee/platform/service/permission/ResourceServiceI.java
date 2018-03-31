package com.yalonglee.platform.service.permission;

import com.yalonglee.platform.entity.permission.*;

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
 * @version [V1.0, 2017/12/10]
 * @see [相关类/方法]
 */
public interface ResourceServiceI {

    /**
     * 通过资源ID获取用户
     * @param resourceId
     * @return
     */
    public Set<User> getUsersByResourceId(Serializable resourceId);

    /**
     * 通过资源ID获取角色
     * @param resourceId
     * @return
     */
    public Set<Role> getRolesByResourceId(Serializable resourceId);

    /**
     * 通过资源ID获取群组
     * @param resourceId
     * @return
     */
    public Set<Group> getGroupsByResourceId(Serializable resourceId);

    /**
     * 通过资源ID获取权限
     * @param resourceId
     * @return
     */
    public Set<Permission> getPermissionsByResourceId(Serializable resourceId);

    /**
     * 通过id获取资源
     * @param id
     * @return
     */
    public Resource get(Serializable id);

    /**
     * 新增资源
     * @param resource
     */
    public void save(Resource resource);

    /**
     * 更新资源
     * @param resource
     */
    public void update(Resource resource);

    /**
     * 新增/更新资源
     * @param resource
     */
    public void saveOrUpdate(Resource resource);

    /**
     * 删除资源
     * @param resource
     */
    public void delete(Resource resource);

}
