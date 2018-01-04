package com.iflytek.operation.entity.permission;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.CascadeType.ALL;

/**
 * <p>《用户》
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
public class User {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 邮箱 | 登录帐号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * salt
     */
    private String salt;
    /**
     * 账号锁定
     */
    private Boolean locked = Boolean.FALSE;
    /**
     * role --> user
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id", nullable=false)
    private Role role;
    /**
     * user --> role
     */
    @OneToMany(cascade=ALL, mappedBy="user")
    private Set<Role> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
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
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(salt, user.salt) &&
                Objects.equals(locked, user.locked) &&
                Objects.equals(role, user.role) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, salt, locked, role, roles);
    }
}
