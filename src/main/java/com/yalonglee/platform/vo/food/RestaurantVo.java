package com.yalonglee.platform.vo.food;

import com.yalonglee.common.base.strategy.BaseUUID;
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
public class RestaurantVo extends BaseUUID {

    /**
     * 老板
     */
    private String boss;

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

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
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
}
