package com.yalonglee.platform.service.impl.food;

import com.yalonglee.platform.dao.food.OrderDaoI;
import com.yalonglee.platform.entity.food.foodOrder;
import com.yalonglee.platform.service.food.OrderServiceI;
import com.yalonglee.platform.vo.food.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

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
    public List<OrderVo> orders() {
        String hql = "select fo.orderFood.foodName as orderFood, fo.orderUser.username as orderUser, fo.orderTime as orderTime, fo.orderState as orderState from foodOrder fo";
        return orderDaoI.findVoListByHql(OrderVo.class, hql);
    }
}
