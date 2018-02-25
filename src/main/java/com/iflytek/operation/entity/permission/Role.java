package com.iflytek.operation.entity.permission;

import com.iflytek.operation.common.base.strategy.BaseUUID;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;

/**
 * <p>《角色》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/9]
 * @see [相关类/方法]
 */
@Entity
public class Role extends BaseUUID {

    /**
     * 角色标识
     */
    private String role;
    /**
     * role --> permission 多对多处理
     */
    @ManyToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "ROLE_PERMISSION",
            joinColumns =
            @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID")
    )
    private List<Permission> permissions = new ArrayList<>();
    /**
     * role --> user 多对多处理
     */
    @ManyToMany(mappedBy = "roles")
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<User> users = new ArrayList<>();

    /**
     * 添加权限
     *
     * @param permission
     */
    public void addPermission(Permission permission) {
        permissions.add(permission);
        permission.getRoles().add(this);
    }

    /**
     * 删除权限
     *
     * @param permission
     */
    public void removeRole(Permission permission) {
        permissions.remove(permission);
        permission.getRoles().remove(permission);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
