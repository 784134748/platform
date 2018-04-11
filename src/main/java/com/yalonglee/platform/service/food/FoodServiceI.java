package com.yalonglee.platform.service.food;

import com.yalonglee.platform.entity.food.Food;
import com.yalonglee.platform.vo.food.FoodVo;

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
public interface FoodServiceI {

    /**
     * 新增菜单
     */
    public Serializable addFood(Food food);

    /**
     * 菜单展示
     */
    public List<FoodVo> foods();
}
