package com.iflytek.operation.service.permission;

import com.iflytek.operation.common.base.Page;
import com.iflytek.operation.entity.permission.Permission;
import com.iflytek.operation.entity.permission.User;

import java.util.Set;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/10]
 * @see [相关类/方法]
 */
public interface PermissionServiceI {

    /**
     * 新增/更新权限
     * @param permission
     */
    public void saveOrUpdate(Permission permission);

    /**
     * 通过用户名获取用户
     * @param username
     * @return
     */
    public User getUserByUsername(String username);

    /**
     * 通过用户id获取用户角色信息
     * @param uid
     * @return
     */
    public Set<String> getRolesByUid(Long uid);

    /**
     * 通过用户id获取用户权限信息
     * @param uid
     * @return
     */
    public Set<String> getPermissionsByUid(Long uid);

}
