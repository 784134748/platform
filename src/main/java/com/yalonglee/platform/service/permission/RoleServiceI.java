package com.yalonglee.platform.service.permission;

import com.yalonglee.platform.entity.permission.Role;

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
public interface RoleServiceI {

    /**
     * 通过id获取角色
     * @param id
     * @return
     */
    public Role get(Serializable id);

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
