package com.yalonglee.platform.vo.permission;

import com.yalonglee.platform.dto.permission.GroupDto;
import com.yalonglee.platform.dto.permission.RoleDto;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2018/3/20]
 * @see [相关类/方法]
 */
public class UserVo {

    /**
     * 用户ID
     */
    private String id;
    /**
     * 邮箱 | 登录帐号
     */
    private String username;
    /**
     * 账号锁定
     */
    private Boolean locked;
    /**
     * user --> role 多对多处理
     */
    private String roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
