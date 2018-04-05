package com.yalonglee.platform.entity.food;

import com.yalonglee.common.base.strategy.BaseUUID;
import com.yalonglee.platform.entity.permission.User;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

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
@Entity
public class Order extends BaseUUID {

    /**
     * 订购的菜品
     */
    @ManyToOne(optional=false)
    @JoinColumn(name="ORDER_FOOD_ID", nullable=false, updatable=false)
    private Food orderFood;

    /**
     * 订购人
     */
    @ManyToOne(optional=false)
    @JoinColumn(name="ORDER_USER_ID", nullable=false, updatable=false)
    private User orderUser;

    /**
     * 订购时间
     */
    private Date orderTime;

    /**
     * 订购状态
     */
    @Convert(converter = OrderState.OrderStateConvert.class)
    private OrderState orderState;

    public Food getOrderFood() {
        return orderFood;
    }

    public void setOrderFood(Food orderFood) {
        this.orderFood = orderFood;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(User orderUser) {
        this.orderUser = orderUser;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}
