package com.yalonglee.platform.service.tree;

import com.yalonglee.platform.entity.data.Node;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/10]
 * @see [相关类/方法]
 */
public interface TreeNodeServiceI {
    /**
     * 新增根节点（树）
     * @param root
     */
    public void addTree(Node root);

    /**
     * 删除根节点（树）
     * @param root
     */
    public void deleteTree(Node root);

    /**
     * 获取根节点（树）
     * @return node
     */
    public Node getTree();

    /**
     * 新增叶子节点
     * @param children
     */
    public void addNode(Node children);

    /**
     * 删除叶子节点
     * @param children
     */
    public void deleteNode(Node children);

}
