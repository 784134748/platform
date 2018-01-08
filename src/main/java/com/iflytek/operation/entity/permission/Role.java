package com.iflytek.operation.entity.permission;

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
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 角色标识
     */
    private String role;
    /**
     * role --> permission 多对多处理
     */
    @ManyToMany
    @JoinTable(name = "ROLE_PERMISSIONS",
            joinColumns=
            @JoinColumn(name="role_id", referencedColumnName="ID"),
            inverseJoinColumns=
            @JoinColumn(name="permission_id", referencedColumnName="ID")
    )
    private Set<Permission> permissions = new HashSet<>();
    /**
     * role --> user 多对多处理
     */
    @ManyToMany(mappedBy = "roles")
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

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
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

        if (id != null ? !id.equals(role1.id) : role1.id != null) {
            return false;
        }
        if (role != null ? !role.equals(role1.role) : role1.role != null) {
            return false;
        }
        if (permissions != null ? !permissions.equals(role1.permissions) : role1.permissions != null) {
            return false;
        }
        return users != null ? users.equals(role1.users) : role1.users == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (permissions != null ? permissions.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        return result;
    }
}
