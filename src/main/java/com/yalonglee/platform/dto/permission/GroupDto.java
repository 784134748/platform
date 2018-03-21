package com.yalonglee.platform.dto.permission;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2018/3/20]
 * @see [相关类/方法]
 */
public class GroupDto {

    /**
     * 群组ID
     */
    private String id;
    /**
     * 群组名称
     */
    private String group;
    /**
     * group --> role 多对多处理
     */
    private List<RoleDto> roles = new ArrayList<>();
    /**
     * group --> user 多对多处理
     */
    private List<UserDto> users = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
