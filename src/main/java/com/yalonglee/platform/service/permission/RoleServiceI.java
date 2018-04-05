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
public interface RoleServiceI {

    /**
     * 通过角色ID获取用户
     * @param roleId
     * @return
     */
    public Set<User> getUsersByRoleId(Serializable roleId);

    /**
     * 通过角色ID获取群组
     * @param roleId
     * @return
     */
    public Set<Group> getGroupsByRoleId(Serializable roleId);

    /**
     * 通过角色ID获取权限
     * @param roleId
     * @return
     */
    public Set<Permission> getPermissionsByRoleId(Serializable roleId);

    /**
     * 通过角色ID获取资源
     * @param roleId
     * @return
     */
    public Set<Resource> getResourcesByRoleId(Serializable roleId);

    /**
     * 通过id获取角色
     * @param id
     * @return
     */
    public Role get(Serializable id);

    /**
     * 通过角色名称获取角色
     * @param role
     * @return
     */
    public Role getRoleByRoleName(String role);

    /**
     * 通过用户id获取用户角色信息
     * @param uid
     * @return
     */
    public Set<String> getRolesByUid(Serializable uid);

    /**
     * 新增/更新角色
     * @param role
     */
    public void saveOrUpdate(Role role);

    /**
     * 删除角色
     * @param role
     */
    public void delete(Role role);

}
