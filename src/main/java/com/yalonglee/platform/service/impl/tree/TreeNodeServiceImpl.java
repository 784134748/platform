package com.yalonglee.platform.service.impl.tree;

import com.yalonglee.platform.dao.tree.TreeNodeDaoI;
import com.yalonglee.platform.entity.data.Node;
import com.yalonglee.platform.service.tree.TreeNodeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/14]
 * @see [相关类/方法]
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TreeNodeServiceImpl implements TreeNodeServiceI {

    @Autowired
    private TreeNodeDaoI treeNodeDaoI;

    @Override
    public void addTree(Node root) {
        treeNodeDaoI.saveOrUpdate(root);
    }

    @Override
    public void deleteTree(Node root) {
        treeNodeDaoI.delete(root);
    }

    @Override
    public Node getTree() {
        String hql = "";
        return treeNodeDaoI.getEntityByHql(hql);
    }

    @Override
    public void addNode(Node chirldren) {
        treeNodeDaoI.saveOrUpdate(chirldren);
    }

    @Override
    public void deleteNode(Node chirldren) {
        treeNodeDaoI.delete(chirldren);
    }
}
