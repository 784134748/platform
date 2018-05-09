package com.yalonglee.platform.entity.food;

import com.yalonglee.common.base.strategy.BaseUUID;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Food extends BaseUUID {

    /**
     * 所属餐厅
     */
    @ManyToOne(optional=false)
    @JoinColumn(name="RESTAURANT_ID", nullable=false, updatable=false)
    private Restaurant restaurant;

    /**
     * 菜品名称
     */
    private String foodName;

    /**
     * 菜品价格
     */
    private double price;

    /**
     * 菜品描述
     */
    private String foodInfo;

    /**
     * 下单总数
     */
    private Long orderNum;

    /**
     * 菜品状态
     */
    @Convert(converter = FoodState.FoodStateConvert.class)
    private FoodState foodState;

    /**
     * 菜品图片
     */
    private String picturePath;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFoodInfo() {
        return foodInfo;
    }

    public void setFoodInfo(String foodInfo) {
        this.foodInfo = foodInfo;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public FoodState getFoodState() {
        return foodState;
    }

    public void setFoodState(FoodState foodState) {
        this.foodState = foodState;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
}
