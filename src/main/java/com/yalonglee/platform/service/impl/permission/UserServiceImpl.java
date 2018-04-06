package com.yalonglee.platform.service.impl.permission;

import com.yalonglee.platform.dao.permission.UserDaoI;
import com.yalonglee.platform.entity.permission.*;
import com.yalonglee.platform.service.permission.UserServiceI;
import com.yalonglee.platform.vo.permission.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
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
public class UserServiceImpl implements UserServiceI {
    @Autowired
    private UserDaoI userDaoI;

    @Override
    public User getUserByUsername(String username) {
        String hql = "from User where username = ?";
        return userDaoI.getEntityByHql(hql, username);
    }

    @Override
    public Set<Group> getGroupsByUsername(String username) {
        return null;
    }

    @Override
    public Set<Role> getRolesByUsername(String username) {
        return null;
    }

    @Override
    public Set<Permission> getPermissionsByUsername(String username) {
        return null;
    }

    @Override
    public Set<Resource> getResourcesByUsername(String username) {
        return null;
    }

    @Override
    public User get(Serializable id) {
        return userDaoI.get(id);
    }

    @Override
    public void save(User user) {
        userDaoI.save(user);
    }

    @Override
    public void update(User user) {
        userDaoI.update(user);
    }

    @Override
    public void saveOrUpdate(User user) {
        userDaoI.saveOrUpdate(user);
    }

    @Override
    public void delete(User user) {
        userDaoI.delete(user);
    }

    @Override
    public List<UserVo> getUsers() {
        String hql = "select u.id as id, u.username as username, u.locked as locked from User u";
        return userDaoI.findVoListByHql(UserVo.class, hql);
    }
}
