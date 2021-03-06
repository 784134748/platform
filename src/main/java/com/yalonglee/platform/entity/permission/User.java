package com.yalonglee.platform.entity.permission;

import com.alibaba.fastjson.annotation.JSONField;
import com.yalonglee.common.base.strategy.BaseUUID;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.NaturalId;

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
public class User extends BaseUUID {

    /**
     * 邮箱 | 登录帐号
     */
    @NaturalId(mutable = true)
    @Column(unique = true)
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
    @JSONField(serialize = false)
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "USER_ROLE",
            joinColumns =
            @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    )
    private List<Role> roles = new ArrayList<>();
    /**
     * user --> group 多对多处理
     */
    @JSONField(serialize = false)
    @ManyToMany(mappedBy = "users")
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Group> groups = new ArrayList<>();

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
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

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
