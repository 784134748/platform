package com.yalonglee.platform.service.permission;

import com.yalonglee.platform.entity.permission.*;
import com.yalonglee.platform.vo.permission.UserVo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
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
public interface UserServiceI {

    /**
     * 通过用户名获取用户
     * @param username
     * @return
     */
    public User getUserByUsername(String username);

    /**
     * 通过用户名获取群组
     * @param username
     * @return
     */
    public Set<Group> getGroupsByUsername(String username);

    /**
     * 通过用户名获取角色
     * @param username
     * @return
     */
    public Set<Role> getRolesByUsername(String username);

    /**
     * 通过用户名获取权限
     * @param username
     * @return
     */
    public Set<Permission> getPermissionsByUsername(String username);

    /**
     * 通过用户名获取权限
     * @param username
     * @return
     */
    public Set<Resource> getResourcesByUsername(String username);

    /**
     * 通过id获取用户
     * @param id
     * @return
     */
    public User get(Serializable id);

    /**
     * 新增用户
     * @param user
     */
    public void save(User user);

    /**
     * 更新用户
     * @param user
     */
    public void update(User user);

    /**
     * 新增/更新用户
     * @param user
     */
    public void saveOrUpdate(User user);

    /**
     * 删除用户
     * @param user
     */
    public void delete(User user);

    /**
     * 获取用户列表
     * @return
     */
    public List<UserVo> getUsers(Map<String,Object> parames);

}
