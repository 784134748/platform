package com.iflytek.operation.entity.permission;

import javax.persistence.*;
import java.util.*;

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
     * user --> role 多对多处理
     */
    @ManyToMany
    @JoinTable(name = "USER_ROLES",
            joinColumns=
            @JoinColumn(name="user_id", referencedColumnName="ID"),
            inverseJoinColumns=
            @JoinColumn(name="role_id", referencedColumnName="ID")
    )
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) {
            return false;
        }
        if (username != null ? !username.equals(user.username) : user.username != null) {
            return false;
        }
        if (password != null ? !password.equals(user.password) : user.password != null) {
            return false;
        }
        if (salt != null ? !salt.equals(user.salt) : user.salt != null) {
            return false;
        }
        if (locked != null ? !locked.equals(user.locked) : user.locked != null) {
            return false;
        }
        return roles != null ? roles.equals(user.roles) : user.roles == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (locked != null ? locked.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
    }
}
