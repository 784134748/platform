package com.iflytek.operation.service.permission;

import com.iflytek.operation.entity.permission.User;

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
public interface UserServiceI {

    /**
     * 新增/更新用户
     * @param user
     */
    public void saveOrUpdate(User user);

}
