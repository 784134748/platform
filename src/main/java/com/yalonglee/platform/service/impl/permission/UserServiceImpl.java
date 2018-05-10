package com.yalonglee.platform.service.impl.permission;

import com.yalonglee.common.base.Page;
import com.yalonglee.platform.dao.permission.UserDaoI;
import com.yalonglee.platform.entity.permission.*;
import com.yalonglee.platform.service.permission.UserServiceI;
import com.yalonglee.platform.vo.permission.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
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
    public Page<UserVo> getUsers(Map<String, Object> parames, Page<UserVo> page) {
        String hql_select = "select u.id as id, u.username as username, u.address as address, u.telephone as telephone, u.number as number, u.sex as sex, u.locked as locked";
        String hql_count = "Select count(*)";
        String hql_from = " from User u";
        StringBuilder hql_where = new StringBuilder();
        hql_where.append(" where 1=1");
        if (null != parames.get("username")) {
            hql_where.append(" and u.username like :username");
        }
        Long count = userDaoI.count(hql_count + hql_from + hql_where, parames);
        page.setTotalCount(count);
        return userDaoI.findVoPageByHql(UserVo.class, page, hql_select + hql_from + hql_where.toString(), parames);
    }
}
