package com.yalonglee.platform.entity.food;

import com.yalonglee.common.base.strategy.BaseUUID;
import com.yalonglee.platform.entity.permission.User;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

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
public class Restaurant extends BaseUUID {

    /**
     * 老板
     */
    @OneToOne @MapsId
    private User boss;

    /**
     * 窗口名称
     */
    private String restaurantName;

    /**
     * 窗口简介
     */
    private String restaurantInfo;

    /**
     * 老板头像
     */
    private String bossPicturePath;

    /**
     * 商户状态
     */
    @Convert(converter = RestaurantState.RestaurantStateConvert.class)
    private RestaurantState restaurantState;

    public User getBoss() {
        return boss;
    }

    public void setBoss(User boss) {
        this.boss = boss;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantInfo() {
        return restaurantInfo;
    }

    public void setRestaurantInfo(String restaurantInfo) {
        this.restaurantInfo = restaurantInfo;
    }

    public String getBossPicturePath() {
        return bossPicturePath;
    }

    public void setBossPicturePath(String bossPicturePath) {
        this.bossPicturePath = bossPicturePath;
    }

    public RestaurantState getRestaurantState() {
        return restaurantState;
    }

    public void setRestaurantState(RestaurantState restaurantState) {
        this.restaurantState = restaurantState;
    }
}
