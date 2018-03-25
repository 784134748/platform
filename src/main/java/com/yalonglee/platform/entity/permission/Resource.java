package com.yalonglee.platform.entity.permission;

import com.yalonglee.common.base.strategy.BaseUUID;
import org.hibernate.annotations.Cascade;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>《资源》
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
public class Resource extends BaseUUID {
    /**
     * 资源名称
     */
    private String resource;
    /**
     * 资源URL
     */
    private String url;
    /**
     * 层级&排序
     */
    private int key;
    /**
     * 状态(false:隐藏,true:开放)
     */
    private boolean state;
    /**
     * resource --> permission 多对多处理
     */
    @ManyToMany(mappedBy = "resources")
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Permission> permissions = new ArrayList<>();

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
