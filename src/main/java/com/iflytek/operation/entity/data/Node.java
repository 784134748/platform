package com.iflytek.operation.entity.data;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

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
public class Node {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 节点信息
     */
    private String name;

    /**
     * 父节点
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Node parent;

    /**
     * 子节点
     */
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Node> children = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Set<Node> getChildren() {
        return children;
    }

    public void setChildren(Set<Node> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return Objects.equals(id, node.id) &&
                Objects.equals(name, node.name) &&
                Objects.equals(parent, node.parent) &&
                Objects.equals(children, node.children);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, parent, children);
    }
}
