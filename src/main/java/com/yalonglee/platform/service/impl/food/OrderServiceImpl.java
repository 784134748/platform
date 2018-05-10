package com.yalonglee.platform.service.impl.food;

import com.yalonglee.common.base.Page;
import com.yalonglee.platform.dao.food.OrderDaoI;
import com.yalonglee.platform.entity.food.foodOrder;
import com.yalonglee.platform.service.food.OrderServiceI;
import com.yalonglee.platform.vo.food.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2018/4/5]
 * @see [相关类/方法]
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderServiceI {

    @Autowired
    private OrderDaoI orderDaoI;

    @Override
    public Serializable addOrder(foodOrder order) {
        return orderDaoI.save(order);
    }

    @Override
    public Page<OrderVo> orders(Map<String, Object> parames, Page<OrderVo> page) {
        String hql_select = "select fo.id as id,fo.orderFood.price as orderPrice, fo.orderFood.foodName as orderFood, fo.orderUser.username as orderUser, fo.orderUser.telephone as telephone, fo.orderUser.address as orderAddress, fo.orderUser.number as studentNumber, fo.orderTime as orderTime, fo.orderState as orderState";
        String hql_count = "Select count(*)";
        String hql_from = " from foodOrder fo";
        StringBuilder hql_where = new StringBuilder();
        hql_where.append(" where 1=1");
        //用户ID
        if (null != parames.get("userId")) {
            hql_where.append(" and fo.orderUser.id = :userId");
        }
        //餐厅ID
        if (null != parames.get("restaurantId")) {
            hql_where.append(" and fo.orderFood.restaurant.id = :restaurantId");
        }
        //菜品名称
        if (null != parames.get("foodName")) {
            hql_where.append(" and fo.orderFood.foodName like :foodName");
        }
        //订购人
        if (null != parames.get("username")) {
            hql_where.append(" and fo.orderUser.username like :username");
        }
        //购物车
        if (null != parames.get("orderType") && "wait".equals(parames.get("orderType"))) {
            if (null != parames.get("waitState")) {
                hql_where.append(" and fo.orderState = :waitState");
            }
        }
        //我的订单
        if (null != parames.get("orderType") && "order".equals(parames.get("orderType"))) {
            if (null != parames.get("waitState")) {
                hql_where.append(" and fo.orderState != :waitState");
            }
        }
        //商家订单
        if (null != parames.get("orderType") && "business".equals(parames.get("orderType"))) {
            if (null != parames.get("waitState")) {
                hql_where.append(" and fo.orderState != :waitState");
            }
            if (null != parames.get("backState")) {
                hql_where.append(" and fo.orderState != :backState");
            }
        }
        Long count = orderDaoI.count(hql_count + hql_from + hql_where, parames);
        page.setTotalCount(count);
        return orderDaoI.findVoPageByHql(OrderVo.class, page, hql_select + hql_from + hql_where.toString(), parames);
    }

    @Override
    public foodOrder getOrderById(Serializable id) {
        return orderDaoI.get(id);
    }

    @Override
    public void updateOrder(foodOrder order) {
        orderDaoI.update(order);
    }
}
