package com.yalonglee.platform.service.impl.food;

import com.yalonglee.common.base.Page;
import com.yalonglee.platform.dao.food.FoodDaoI;
import com.yalonglee.platform.entity.food.Food;
import com.yalonglee.platform.service.food.FoodServiceI;
import com.yalonglee.platform.vo.food.FoodVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
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
    public Page<FoodVo> foods(Map<String, Object> parames, Page<FoodVo> page) {
        String hql_select = "Select f.id as id, f.foodState as foodState, f.foodName as foodName, f.price as price, f.foodInfo as foodInfo, f.picturePath as picturePath";
        String hql_count = "Select count(*)";
        String hql_from = " from Food f";
        StringBuilder hql_where = new StringBuilder();
        hql_where.append(" where 1=1");
        //商户ID
        if (null != parames.get("restaurantId")) {
            hql_where.append(" and f.restaurant.id = :restaurantId");
        }
        //菜品ID
        if (null != parames.get("foodId")) {
            hql_where.append(" and f.id = :foodId");
        }
        //菜品名称
        if (null != parames.get("foodName")) {
            hql_where.append(" and f.foodName like :foodName");
        }
        //菜品状态
        if (null != parames.get("foodState")) {
            hql_where.append(" and f.foodState = :foodState");
        }
        //店铺状态
//        if (null != parames.get("restaurantState")) {
//            hql_where.append(" and f.restaurant.restaurantState = :restaurantState");
//        }
        Long count = foodDaoI.count(hql_count + hql_from + hql_where, parames);
        page.setTotalCount(count);
        return foodDaoI.findVoPageByHql(FoodVo.class, page, hql_select + hql_from + hql_where.toString(), parames);

    }

    @Override
    public Food getFoodById(Serializable id) {
        return foodDaoI.get(id);
    }

    @Override
    public void updateFood(Food food) {
        foodDaoI.update(food);
    }
}
