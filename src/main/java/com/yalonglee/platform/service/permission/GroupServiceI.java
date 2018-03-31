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
public interface GroupServiceI {

    /**
     * 通过群组ID获取用户
     * @param groupId
     * @return
     */
    public Set<User> getUsersByResourceId(Serializable groupId);

    /**
     * 通过群组ID获取角色
     * @param groupId
     * @return
     */
    public Set<Role> getRolesByResourceId(Serializable groupId);

    /**
     * 通过群组ID获取权限
     * @param groupId
     * @return
     */
    public Set<Permission> getPermissionsByResourceId(Serializable groupId);

    /**
     * 通过群组ID获取资源
     * @param groupId
     * @return
     */
    public Set<Resource> getResourcesByGroupId(Serializable groupId);

    /**
     * 通过id获取群组
     * @param id
     * @return
     */
    public Group get(Serializable id);

    /**
     * 新增群组
     * @param group
     */
    public void save(Group group);

    /**
     * 更新群组
     * @param group
     */
    public void update(Group group);

    /**
     * 新增/更新群组
     * @param group
     */
    public void saveOrUpdate(Group group);

    /**
     * 删除群组
     * @param group
     */
    public void delete(Group group);

}
