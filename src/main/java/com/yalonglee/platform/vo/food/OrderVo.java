package com.yalonglee.platform.vo.food;

import com.yalonglee.common.base.strategy.BaseUUID;
import com.yalonglee.platform.entity.food.Food;
import com.yalonglee.platform.entity.food.OrderState;
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
public class OrderVo extends BaseUUID {

    /**
     * 订购的菜品
     */
    private String orderFood;

    /**
     * 订购人
     */
    private String orderUser;

    /**
     * 订购时间
     */
    private String orderTime;

    /**
     * 订购状态
     */
    private Boolean orderState;

    public String getOrderFood() {
        return orderFood;
    }

    public void setOrderFood(String orderFood) {
        this.orderFood = orderFood;
    }

    public String getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Boolean getOrderState() {
        return orderState;
    }

    public void setOrderState(Boolean orderState) {
        this.orderState = orderState;
    }
}
