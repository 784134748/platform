package com.yalonglee.platform.service.food;

import com.yalonglee.platform.entity.food.Restaurant;
import com.yalonglee.platform.vo.food.RestaurantVo;

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
public interface RestaurantServiceI {

    /**
     * 新增餐厅
     */
    public Serializable addRestaurant(Restaurant restaurant);

    /**
     * 更新餐厅信息
     */
    public void updateRestaurant(Restaurant restaurant);

    /**
     * 餐厅列表
     */
    public List<RestaurantVo> restaurants(Map<String, Object> parames);

    /**
     * 通过用户ID获取餐厅
     */
    public Restaurant getResturantByUserId(String username);
}
