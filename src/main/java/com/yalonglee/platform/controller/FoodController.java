package com.yalonglee.platform.controller;

import com.yalonglee.common.bean.BaseResult;
import com.yalonglee.common.bean.LayuiResult;
import com.yalonglee.platform.entity.food.Food;
import com.yalonglee.platform.entity.food.foodOrder;
import com.yalonglee.platform.entity.food.OrderState;
import com.yalonglee.platform.entity.food.Restaurant;
import com.yalonglee.platform.entity.permission.Role;
import com.yalonglee.platform.entity.permission.User;
import com.yalonglee.platform.service.food.FoodServiceI;
import com.yalonglee.platform.service.food.OrderServiceI;
import com.yalonglee.platform.service.food.RestaurantServiceI;
import com.yalonglee.platform.service.permission.RoleServiceI;
import com.yalonglee.platform.service.permission.UserServiceI;
import com.yalonglee.platform.vo.food.AddRestaurantVo;
import com.yalonglee.platform.vo.food.FoodVo;
import com.yalonglee.platform.vo.food.OrderVo;
import com.yalonglee.platform.vo.food.RestaurantVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableWebMvc
@RequestMapping(value = "/food")
@Api(value = "订餐业务接口")
public class FoodController {

    @Autowired
    private RestaurantServiceI restaurantServiceI;
    @Autowired
    private OrderServiceI orderServiceI;
    @Autowired
    private FoodServiceI foodServiceI;
    @Autowired
    private RoleServiceI roleServiceI;
    @Autowired
    private UserServiceI userServiceI;

    /**
     * 展示菜品
     */
    @ApiOperation(value = "展示菜品")
    @RequestMapping(value = "/foods.do", method = RequestMethod.GET)
    @ResponseBody
    public LayuiResult<FoodVo> getFoods(String type,String foodId) {
        Map<String, Object> parames = new HashMap<>();
        if ("1".equals(type)){
            String currentUsername = (String) SecurityUtils.getSubject().getPrincipal();
            Restaurant restaurant = restaurantServiceI.getResturantByUserId(currentUsername);
            parames.put("restaurantId",restaurant.getId());
        }
        if(StringUtils.isNotBlank(foodId)){
            parames.put("foodId",foodId);
        }
        LayuiResult<FoodVo> layuiResult = new LayuiResult<>();
        List<FoodVo> list = foodServiceI.foods(parames);
        layuiResult.setData(list);
        layuiResult.setCode(0);
        layuiResult.setCount(10L);
        return layuiResult;
    }

    /**
     * 展示店铺
     */
    @ApiOperation(value = "展示店铺")
    @RequestMapping(value = "/restuarants.do", method = RequestMethod.GET)
    @ResponseBody
    public LayuiResult<RestaurantVo> getRestuarants() {
        LayuiResult<RestaurantVo> layuiResult = new LayuiResult<>();
        List<RestaurantVo> list = restaurantServiceI.restaurants();
        layuiResult.setData(list);
        layuiResult.setCode(0);
        layuiResult.setCount(10L);
        return layuiResult;
    }

    /**
     * 展示订单
     */
    @ApiOperation(value = "展示订单")
    @RequestMapping(value = "/orders.do", method = RequestMethod.GET)
    @ResponseBody
    public LayuiResult<OrderVo> getOrders() {
        LayuiResult<OrderVo> layuiResult = new LayuiResult<>();
        List<OrderVo> list = orderServiceI.orders();
        layuiResult.setData(list);
        layuiResult.setCode(0);
        layuiResult.setCount(10L);
        return layuiResult;
    }

    /**
     * 新增店铺
     */
    @ApiOperation(value = "新增商户")
    @RequestMapping(value = "/addRestuarant.do", method = RequestMethod.PUT)
    public BaseResult addRestuarant(@RequestBody AddRestaurantVo addRestaurantVo) {
        BaseResult baseResult = new BaseResult();
        User user = new User();
        user.setUsername(addRestaurantVo.getUsername());
        user.setPassword(addRestaurantVo.getPassword());
        user.setSalt("1234");
        user.setLocked(Boolean.FALSE);
        Role role = roleServiceI.getRoleByRoleName("business");
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(addRestaurantVo.getRestaurantName());
        user.getRoles().add(role);
        restaurant.setBoss(user);
        try {
            restaurantServiceI.addRestaurant(restaurant);
            baseResult.setFlag(true);
            baseResult.setMsg("新增成功");
        } catch (Exception e) {
            baseResult.setFlag(false);
            baseResult.setMsg("新增失败");
        }

        return baseResult;
    }

    /**
     * 新增店铺
     */
    @ApiOperation(value = "完善商户信息")
    @RequestMapping(value = "/updateRestuarant.do", method = RequestMethod.PUT)
    public BaseResult updateRestuarant(@RequestBody AddRestaurantVo addRestaurantVo) {
        BaseResult baseResult = new BaseResult();
        String currentUsername = (String) SecurityUtils.getSubject().getPrincipal();
        Restaurant restaurant = restaurantServiceI.getResturantByUserId(currentUsername);
        if (null != restaurant) {
            restaurant.setRestaurantInfo(addRestaurantVo.getRestaurantInfo());
            restaurant.setBossPicturePath(addRestaurantVo.getBossPicturePath());
            try {
                restaurantServiceI.updateRestaurant(restaurant);
                baseResult.setMsg("更新成功");
                baseResult.setFlag(true);
            } catch (Exception e) {
                baseResult.setMsg("更新失败");
                baseResult.setFlag(false);
            }
        }
        return baseResult;
    }

    /**
     * 新增菜品
     */
    @ApiOperation(value = "新增菜品")
    @RequestMapping(value = "/addFood.do", method = RequestMethod.PUT)
    public BaseResult addFood(@RequestBody Food food) {
        BaseResult baseResult = new BaseResult();
        String currentUsername = (String) SecurityUtils.getSubject().getPrincipal();
        Restaurant restaurant = restaurantServiceI.getResturantByUserId(currentUsername);
        if (null != restaurant) {
            food.setRestaurant(restaurant);
            foodServiceI.addFood(food);
            baseResult.setFlag(true);
            baseResult.setMsg("新增成功");
            return baseResult;
        }
        baseResult.setFlag(false);
        baseResult.setMsg("新增失败");
        return baseResult;
    }

    /**
     * 添加购物车
     */
    @ApiOperation(value = "添加购物车")
    @RequestMapping(value = "/addOrder.do", method = RequestMethod.POST)
    public BaseResult addOrder(String foodId) {
        BaseResult baseResult = new BaseResult();
        String currentUsername = (String) SecurityUtils.getSubject().getPrincipal();
        if(StringUtils.isBlank(currentUsername)){
            baseResult.setFlag(false);
            baseResult.setMsg("请先登录");
            return baseResult;
        }
        User user = userServiceI.getUserByUsername(currentUsername);
        foodOrder order = new foodOrder();
        Food food = foodServiceI.getFoodById(foodId);
        order.setOrderFood(food);
        order.setOrderUser(user);
        order.setOrderState(OrderState.WAIT_PAY);
        order.setOrderTime(new Date());
        try {
            orderServiceI.addOrder(order);
        }catch (Exception e){
            baseResult.setFlag(false);
            baseResult.setMsg("加入购物车失败！");
            return baseResult;
        }
        baseResult.setFlag(true);
        baseResult.setMsg("已加入购物车！");
        return baseResult;

    }

}