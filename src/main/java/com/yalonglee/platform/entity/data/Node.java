package com.yalonglee.platform.entity.data;

import com.yalonglee.common.base.strategy.BaseUUID;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/19]
 * @see [相关类/方法]
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Node extends BaseUUID {

    /**
     * 节点信息
     */
    private String name;
    /**
     * 层次
     */
    private int level;
    /**
     * 是否为根节点
     */
    @Column(name = "is_root")
    private boolean root;
    /**
     * 父节点
     */
    @ManyToOne
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "parent_id", nullable = false)
    private Node parent;
    /**
     * 子节点
     */
    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Node> childrens = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Node> childrens) {
        this.childrens = childrens;
    }
}
