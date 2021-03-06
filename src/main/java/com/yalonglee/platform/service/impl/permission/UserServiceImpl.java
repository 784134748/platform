package com.yalonglee.platform.service.impl.permission;

import com.yalonglee.platform.dao.permission.UserDaoI;
import com.yalonglee.platform.entity.permission.User;
import com.yalonglee.platform.service.permission.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
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
    public User getUserByUsername(String username) {
        String hql = "from User where username = ?";
        return userDaoI.getEntityByHql(hql, username);
    }

    @Override
    public void saveOrUpdate(User user) {
        userDaoI.saveOrUpdate(user);
    }

    @Override
    public void delete(User user) {
        userDaoI.delete(user);
    }
}
