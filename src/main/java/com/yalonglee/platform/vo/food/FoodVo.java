package com.yalonglee.platform.vo.food;

import com.yalonglee.common.base.strategy.BaseUUID;
import com.yalonglee.platform.entity.food.FoodState;
import com.yalonglee.platform.entity.food.Restaurant;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

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
public class FoodVo extends BaseUUID {

    /**
     * 所属餐厅
     */
    private String restaurantId;

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
     * 菜品图片
     */
    private String picturePath;

    /**
     * 菜品状态
     */
    private FoodState foodState;

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
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

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public FoodState getFoodState() {
        return foodState;
    }

    public void setFoodState(FoodState foodState) {
        this.foodState = foodState;
    }
}
