package com.iflytek.operation.common.secret;

import com.iflytek.operation.entity.permission.User;
import com.iflytek.operation.service.permission.PermissionServiceI;
import com.iflytek.operation.service.permission.RoleServiceI;
import com.iflytek.operation.service.permission.UserServiceI;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/15]
 * @see [相关类/方法]
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private PermissionServiceI permissionServiceI;

    /**
     * 用户授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        User user = getUserByUsername(username);
        Set<String> roles = getRolesByUid(user.getId());
        Set<String> permissions = getPermissionsByUid(user.getId());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
     * 身份认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());
        User user = permissionServiceI.getUserByUsername(username);
        //UnknownAccountException
        if (null == user) {
            throw new UnknownAccountException();
        }
        //IncorrectCredentialsException
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException();
        }
        //LockedAccountException
        if (Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException();
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                getName()
        );
        return authenticationInfo;
    }

    /**
     * 通过登录账号获取用户信息
     */
    public User getUserByUsername(String username){
        User user = permissionServiceI.getUserByUsername(username);
        return user;
    }

    /**
     * 通过用户id获取角色信息
     */
    public Set<String> getRolesByUid(Long uid){
        Set<String> roles = permissionServiceI.getRolesByUid(uid);
        return roles;
    }
    /**
     * 通过用户id获取权限信息
     */
    public Set<String> getPermissionsByUid(Long uid){
        Set<String> permissions = permissionServiceI.getPermissionsByUid(uid);
        return permissions;
    }
}
