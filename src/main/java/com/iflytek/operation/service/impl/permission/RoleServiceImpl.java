package com.iflytek.operation.service.impl.permission;

import com.iflytek.operation.dao.permission.RoleDaoI;
import com.iflytek.operation.entity.permission.Role;
import com.iflytek.operation.service.permission.RoleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class RoleServiceImpl implements RoleServiceI {
    @Autowired
    private RoleDaoI roleDaoI;

    @Override
    public void saveOrUpdate(Role role) {
        roleDaoI.saveOrUpdate(role);
    }
}
