package com.yalonglee.platform.vo.permission;

import com.yalonglee.platform.dto.permission.GroupDto;
import com.yalonglee.platform.dto.permission.PermissionDto;
import com.yalonglee.platform.dto.permission.UserDto;

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
public class RoleVo {

    /**
     * 角色ID
     */
    private String id;
    /**
     * 角色标识
     */
    private String role;
    /**
     * role --> permission 多对多处理
     */
    private List<PermissionDto> permissions = new ArrayList<>();
    /**
     * role --> user 多对多处理
     */
    private List<UserDto> users = new ArrayList<>();
    /**
     * role --> group 多对多处理
     */
    private List<GroupDto> groups = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<PermissionDto> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionDto> permissions) {
        this.permissions = permissions;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }

    public List<GroupDto> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupDto> groups) {
        this.groups = groups;
    }
}
