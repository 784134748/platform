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
public interface PermissionServiceI {

    /**
     * 通过权限ID获取用户
     * @param permissionId
     * @return
     */
    public Set<User> getUsersByPermissionId(Serializable permissionId);

    /**
     * 通过权限ID获取角色
     * @param permissionId
     * @return
     */
    public Set<Role> getRolesByPermissionId(Serializable permissionId);

    /**
     * 通过权限ID获取群组
     * @param permissionId
     * @return
     */
    public Set<Group> getGroupsByPermissionId(Serializable permissionId);

    /**
     * 通过权限ID获取资源
     * @param permissionId
     * @return
     */
    public Set<Resource> getResourcesByPermissionId(Serializable permissionId);

    /**
     * 通过id获取权限
     * @param id
     * @return
     */
    public Permission get(Serializable id);

    /**
     * 通过用户id获取用户权限信息
     * @param uid
     * @return
     */
    public Set<String> getPermissionsByUid(Serializable uid);

    /**
     * 新增/更新权限
     * @param permission
     */
    public void saveOrUpdate(Permission permission);

    /**
     * 删除权限
     * @param permission
     */
    public void delete(Permission permission);

}
