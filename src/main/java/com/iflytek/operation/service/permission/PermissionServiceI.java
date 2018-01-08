package com.iflytek.operation.service.permission;

import com.iflytek.operation.entity.permission.Permission;

import java.io.Serializable;
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
    public Set<String> getPermissionsByUid(Long uid);

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
