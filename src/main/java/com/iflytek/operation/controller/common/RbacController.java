package com.iflytek.operation.controller.common;

import com.iflytek.operation.entity.permission.Permission;
import com.iflytek.operation.entity.permission.Role;
import com.iflytek.operation.entity.permission.User;
import com.iflytek.operation.service.permission.PermissionServiceI;
import com.iflytek.operation.service.permission.RoleServiceI;
import com.iflytek.operation.service.permission.UserServiceI;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/17]
 * @see [相关类/方法]
 */
@Controller
@RequestMapping(value = "/rbac")
public class RbacController {

    @Autowired
    private UserServiceI userServiceI;
    @Autowired
    private RoleServiceI roleServiceI;
    @Autowired
    private PermissionServiceI permissionServiceI;

    /**
     * 身份认证失败
     */
    @RequestMapping(value = "/login.do")
    public void toLoginPage(HttpServletRequest httpServletRequest) {
        String exceptionClassName = (String) httpServletRequest.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        if(StringUtils.isNotBlank(exceptionClassName)){
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                System.out.println("用户名不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                System.out.println("密码错误");
            } else if (LockedAccountException.class.getName().equals(exceptionClassName)) {
                System.out.println("账户已锁定");
            } else {
                System.out.println("未知错误");
            }
        }
    }

    /**
     * 新增/修改用户
     * @param user
     */
    @RequestMapping(value = "/user/saveOrUpdate.do")
    public void saveOrUpdateUser(User user){
        userServiceI.saveOrUpdate(user);
    }

    /**
     * 新增/修改角色
     * @param role
     */
    @RequestMapping(value = "/role/saveOrUpdate.do")
    public void saveOrUpdateRole(Role role){
        roleServiceI.saveOrUpdate(role);
    }

    /**
     * 新增/修改权限
     * @param permission
     */
    @RequestMapping(value = "/permission/saveOrUpdate.do")
    public void saveOrUpdatePermission(Permission permission){
        permissionServiceI.saveOrUpdate(permission);
    }

}
