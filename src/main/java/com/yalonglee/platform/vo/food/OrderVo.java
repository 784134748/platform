package com.yalonglee.platform.vo.food;

import com.yalonglee.common.base.strategy.BaseUUID;
import com.yalonglee.platform.entity.food.OrderState;

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
     * 订购金额
     */
    private double orderPrice;

    /**
     * 订购时间
     */
    private Date orderTime;

    /**
     * 联系方式
     */
    private String telephone;

    /**
     * 宿舍地址
     */
    private String orderAddress;

    /**
     * 学生证件
     */
    private String studentNumber;

    /**
     * 订购状态
     */
    private OrderState orderState;

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

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}
