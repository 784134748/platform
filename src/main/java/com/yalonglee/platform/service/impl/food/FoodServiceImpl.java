package com.yalonglee.platform.service.impl.food;

import com.yalonglee.platform.dao.food.FoodDaoI;
import com.yalonglee.platform.entity.food.Food;
import com.yalonglee.platform.service.food.FoodServiceI;
import com.yalonglee.platform.vo.food.FoodVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
@Transactional(rollbackFor = Exception.class)
public class FoodServiceImpl implements FoodServiceI {

    @Autowired
    private FoodDaoI foodDaoI;

    @Override
    public Serializable addFood(Food food) {
        return foodDaoI.save(food);
    }

    @Override
    public List<FoodVo> foods() {
        String hql = "Select f.foodName as foodName, f.price as price from Food f";
        return foodDaoI.findVoListByHql(FoodVo.class, hql);
    }
}
