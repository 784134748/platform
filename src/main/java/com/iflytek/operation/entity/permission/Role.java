package com.iflytek.operation.entity.permission;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.CascadeType.ALL;

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
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 角色标识
     */
    private String role;
    /**
     * permission --> role
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="permission_id", nullable=false)
    private Permission permission;
    /**
     * role --> permission
     */
    @OneToMany(cascade=ALL, mappedBy="role")
    private Set<Permission> permissions = new HashSet<>();
    /**
     * user --> role
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    /**
     * role --> user
     */
    @OneToMany(cascade=ALL, mappedBy="role")
    private Set<User> users = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role1 = (Role) o;
        return Objects.equals(id, role1.id) &&
                Objects.equals(role, role1.role) &&
                Objects.equals(permission, role1.permission) &&
                Objects.equals(permissions, role1.permissions) &&
                Objects.equals(user, role1.user) &&
                Objects.equals(users, role1.users);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, role, permission, permissions, user, users);
    }
}
