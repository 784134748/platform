package com.yalonglee.platform.entity.permission;

import com.alibaba.fastjson.annotation.JSONField;
import com.yalonglee.common.base.strategy.BaseUUID;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;

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
public class Permission extends BaseUUID {

    /**
     * 权限字符串
     */
    private String permission;
    /**
     * permission --> role 多对多处理
     */
    @JSONField(serialize = false)
    @ManyToMany(mappedBy = "permissions")
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Role> roles = new ArrayList<>();
    /**
     * permission --> resource 多对多处理
     */
    @ManyToMany
    @JSONField(serialize = false)
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "PERMISSION_RESOURCE",
            joinColumns =
            @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "RESOURCE_ID", referencedColumnName = "ID")
    )
    private List<Resource> resources = new ArrayList<>();

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
