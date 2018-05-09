package com.yalonglee.platform.service.food;

import com.yalonglee.platform.entity.food.foodOrder;
import com.yalonglee.platform.vo.food.OrderVo;

import java.io.Serializable;
import java.util.List;
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
public interface OrderServiceI {

    /**
     * 新增订单
     */
    public Serializable addOrder(foodOrder order);

    /**
     * 订单展示
     */
    public List<OrderVo> orders(Map<String, Object> parames);

    /**
     * 通过id获取Order
     */
    public foodOrder getOrderById(Serializable id);

    /**
     * 更新Order
     */
    public void updateOrder(foodOrder order);

}
