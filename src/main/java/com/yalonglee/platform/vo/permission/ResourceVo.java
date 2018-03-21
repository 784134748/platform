package com.yalonglee.platform.vo.permission;

import com.yalonglee.platform.dto.permission.PermissionDto;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2018/3/20]
 * @see [相关类/方法]
 */
public class ResourceVo {

    /**
     * 资源ID
     */
    private String id;
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
    private List<PermissionDto> permissions = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public List<PermissionDto> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionDto> permissions) {
        this.permissions = permissions;
    }
}
