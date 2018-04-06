package com.yalonglee.platform.entity.permission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yalonglee.common.base.strategy.BaseUUID;
import org.hibernate.annotations.Cascade;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>《群组》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2018/3/17]
 * @see [相关类/方法]
 */
@Entity
public class Group extends BaseUUID {

    /**
     * 群组名称
     */
    private String group;
    /**
     * group --> role 多对多处理
     */
    @JsonIgnore
    @ManyToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "GROUP_ROLE",
            joinColumns =
            @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    )
    private List<Role> roles = new ArrayList<>();
    /**
     * group --> user 多对多处理
     */
    @JsonIgnore
    @ManyToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "GROUP_USER",
            joinColumns =
            @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    )
    private List<User> users = new ArrayList<>();

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
