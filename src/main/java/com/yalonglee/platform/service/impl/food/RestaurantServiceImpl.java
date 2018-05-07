package com.yalonglee.platform.service.impl.food;

import com.yalonglee.platform.dao.food.RestaurantDaoI;
import com.yalonglee.platform.dao.permission.UserDaoI;
import com.yalonglee.platform.entity.food.Restaurant;
import com.yalonglee.platform.entity.permission.User;
import com.yalonglee.platform.service.food.RestaurantServiceI;
import com.yalonglee.platform.vo.food.RestaurantVo;
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
public class RestaurantServiceImpl implements RestaurantServiceI {

    @Autowired
    private RestaurantDaoI restaurantDaoI;
    @Autowired
    private UserDaoI userDaoI;

    @Override
    public Serializable addRestaurant(Restaurant restaurant) {
        return restaurantDaoI.save(restaurant);
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        restaurantDaoI.saveOrUpdate(restaurant);
    }

    @Override
    public List<RestaurantVo> restaurants() {
        String hql = "select u.username as boss, r.restaurantName as restaurantName, r.restaurantInfo as restaurantInfo, r.bossPicturePath as bossPicturePath from Restaurant r left join r.boss u";
        return restaurantDaoI.findVoListByHql(RestaurantVo.class, hql);
    }

    @Override
    public Restaurant getResturantByUserId(String username) {
        String hql_user = "from User u where u.username = ?";
        User user = userDaoI.getEntityByHql(hql_user,username);
        String hql_res = "from Restaurant r where r.boss.id = ?";
        return restaurantDaoI.getEntityByHql(hql_res, user.getId());
    }
}
