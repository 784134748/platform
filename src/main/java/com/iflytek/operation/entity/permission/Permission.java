package com.iflytek.operation.entity.permission;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

/**
 * <p>《权限》
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
public class Permission {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 权限字符串
     */
    private String permission;
    /**
     * role --> permission
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id", nullable=false)
    private Role role;
    /**
     * permission --> role
     */
    @OneToMany(cascade=ALL, mappedBy="permission")
    private Set<Role> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Permission that = (Permission) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(permission, that.permission) &&
                Objects.equals(role, that.role) &&
                Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, permission, role, roles);
    }
}
