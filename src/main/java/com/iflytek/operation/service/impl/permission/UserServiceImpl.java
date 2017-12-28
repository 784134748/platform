package com.iflytek.operation.service.impl.permission;

import com.iflytek.operation.dao.permission.UserDaoI;
import com.iflytek.operation.entity.permission.User;
import com.iflytek.operation.service.permission.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void saveOrUpdate(User user) {
        userDaoI.saveOrUpdate(user);
    }
}
