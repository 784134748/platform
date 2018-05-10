package com.yalonglee.platform.controller;

import com.yalonglee.common.base.Page;
import com.yalonglee.common.bean.BaseResult;
import com.yalonglee.common.bean.LayuiResult;
import com.yalonglee.platform.entity.food.*;
import com.yalonglee.platform.entity.permission.AcountState;
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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Date;
import java.util.HashMap;
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
    public LayuiResult<FoodVo> getFoods(int limit, int page, String type, String foodId, String restaurantId, String foodName) {
        Map<String, Object> parames = new HashMap<>();
        Page<FoodVo> pagevo = new Page<>();
        pagevo.setPageSize(limit);
        pagevo.setCurrentPageNo(page);
        parames.put("limit", limit);
        parames.put("page", page);
        if (StringUtils.isNotBlank(foodName)) {
            parames.put("foodName", "%" + foodName + "%");
        }
        if ("1".equals(type)) {
            String currentUsername = (String) SecurityUtils.getSubject().getPrincipal();
            Restaurant restaurant = restaurantServiceI.getResturantByUserId(currentUsername);
            parames.put("restaurantId", restaurant.getId());
        }
        if (StringUtils.isNotBlank(foodId)) {
            parames.put("foodId", foodId);
        }
        if (StringUtils.isNotBlank(restaurantId)) {
            parames.put("restaurantId", restaurantId);
        }
        LayuiResult<FoodVo> layuiResult = new LayuiResult<>();
        Page<FoodVo> page_result = foodServiceI.foods(parames, pagevo);
        layuiResult.setData(page_result.getResult());
        layuiResult.setCode(0);
        layuiResult.setFlag(true);
        layuiResult.setCount(page_result.getTotalCount());
        return layuiResult;
    }

    /**
     * 展示店铺
     */
    @ApiOperation(value = "展示店铺")
    @RequestMapping(value = "/restuarants.do", method = RequestMethod.GET)
    @ResponseBody
    public LayuiResult<RestaurantVo> getRestuarants(int limit, int page, String type, String restaurantName, String username) {
        LayuiResult<RestaurantVo> layuiResult = new LayuiResult<>();
        Map<String, Object> parames = new HashMap<>();
        Page<RestaurantVo> pagevo = new Page<>();
        pagevo.setPageSize(limit);
        pagevo.setCurrentPageNo(page);
        if (StringUtils.isNotBlank(restaurantName)) {
            parames.put("restaurantName", "%" + restaurantName + "%");
        }
        if (StringUtils.isNotBlank(username)) {
            parames.put("username", "%" + username + "%");
        }
        if ("databack".equals(type)) {
            String currentUsername = (String) SecurityUtils.getSubject().getPrincipal();
            Restaurant restaurant = restaurantServiceI.getResturantByUserId(currentUsername);
            if (null == restaurant) {
                layuiResult.setFlag(false);
                layuiResult.setCode(-1);
                return layuiResult;
            }
            parames.put("restaurantId", restaurant.getId());
        }
        Page<RestaurantVo> page_result = restaurantServiceI.restaurants(parames, pagevo);
        layuiResult.setFlag(true);
        layuiResult.setData(page_result.getResult());
        layuiResult.setCode(0);
        layuiResult.setCount(page_result.getTotalCount());
        return layuiResult;
    }

    /**
     * 展示订单
     */
    @ApiOperation(value = "展示订单")
    @RequestMapping(value = "/orders.do", method = RequestMethod.GET)
    @ResponseBody
    public LayuiResult<OrderVo> getOrders(int limit, int page, String type, String foodName, String username) {
        Map<String, Object> parames = new HashMap<>();
        Page<OrderVo> pagevo = new Page<>();
        pagevo.setPageSize(limit);
        pagevo.setCurrentPageNo(page);
        if (StringUtils.isNotBlank(foodName)) {
            parames.put("foodName", "%" + foodName + "%");
        }
        if (StringUtils.isNotBlank(username)) {
            parames.put("username", "%" + username + "%");
        }
        //订单
        if ("order".equals(type)) {
            String currentUsername = (String) SecurityUtils.getSubject().getPrincipal();
            User user = userServiceI.getUserByUsername(currentUsername);
            parames.put("userId", user.getId());
            //展示非购物车内的订单
            parames.put("orderState", OrderState.WAIT);
            parames.put("orderType", type);
        }
        //购物车
        if ("wait".equals(type)) {
            String currentUsername = (String) SecurityUtils.getSubject().getPrincipal();
            User user = userServiceI.getUserByUsername(currentUsername);
            parames.put("userId", user.getId());
            //仅展示未确认的订单
            parames.put("waitState", OrderState.WAIT);
            parames.put("orderType", type);

        }
        //商家展示
        if ("business".equals(type)) {
            String currentUsername = (String) SecurityUtils.getSubject().getPrincipal();
            Restaurant restaurant = restaurantServiceI.getResturantByUserId(currentUsername);
            //非管理员的商户
            if (null != restaurant) {
                parames.put("restaurantId", restaurant.getId());
                //不展示购物车内订单和退订订单
                parames.put("waitState", OrderState.WAIT);
                parames.put("backState", OrderState.BACK);
                parames.put("orderType", type);
            }
        }
        LayuiResult<OrderVo> layuiResult = new LayuiResult<>();
        Page<OrderVo> page_result = orderServiceI.orders(parames, pagevo);
        layuiResult.setData(page_result.getResult());
        layuiResult.setCode(0);
        layuiResult.setCount(page_result.getTotalCount());
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
        user.setLocked(AcountState.NORMOL);
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
            restaurant.setRestaurantName(addRestaurantVo.getRestaurantName());
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
     * 新增/编辑菜品
     */
    @ApiOperation(value = "新增/编辑菜品")
    @RequestMapping(value = "/addFood.do", method = RequestMethod.PUT)
    public BaseResult addFood(@RequestBody Food food) {
        BaseResult baseResult = new BaseResult();
        String currentUsername = (String) SecurityUtils.getSubject().getPrincipal();
        Restaurant restaurant = restaurantServiceI.getResturantByUserId(currentUsername);
        if (null != restaurant) {
            if (StringUtils.isNotBlank(food.getId())) {
                try {
                    Food food_update = foodServiceI.getFoodById(food.getId());
                    BeanUtils.copyProperties(food, food_update, new String[]{"id", "orderNum", "foodState", "restaurant"});
                    foodServiceI.updateFood(food_update);
                    baseResult.setFlag(true);
                    baseResult.setMsg("更新成功");
                    return baseResult;
                } catch (Exception e) {
                    baseResult.setFlag(true);
                    baseResult.setMsg("更新失败");
                    return baseResult;
                }
            }
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
        if (StringUtils.isNotBlank(foodId)) {
            String currentUsername = (String) SecurityUtils.getSubject().getPrincipal();
            if (StringUtils.isBlank(currentUsername)) {
                baseResult.setFlag(false);
                baseResult.setMsg("请先登录");
                return baseResult;
            }
            User user = userServiceI.getUserByUsername(currentUsername);
            if (StringUtils.isBlank(user.getTelephone()) || StringUtils.isBlank(user.getAddress()) || StringUtils.isBlank(user.getNumber())) {
                baseResult.setFlag(false);
                baseResult.setMsg("请先完善个人信息");
                return baseResult;
            }
            foodOrder order = new foodOrder();
            Food food = foodServiceI.getFoodById(foodId);
            order.setOrderFood(food);
            order.setOrderUser(user);
            order.setOrderState(OrderState.WAIT);
            order.setOrderTime(new Date());
            try {
                orderServiceI.addOrder(order);
            } catch (Exception e) {
                baseResult.setFlag(false);
                baseResult.setMsg("加入购物车失败！");
                return baseResult;
            }
            baseResult.setFlag(true);
            baseResult.setMsg("已加入购物车！");
            return baseResult;
        }
        return baseResult;
    }

    /**
     * 修改订单状态
     */
    @ApiOperation(value = "修改订单状态")
    @RequestMapping(value = "/fixOrderState.do", method = RequestMethod.POST)
    public BaseResult fixOrderState(String orderState, String orderId) {
        BaseResult baseResult = new BaseResult();
        if (StringUtils.isNotBlank(orderId)) {
            foodOrder foodOrder = orderServiceI.getOrderById(orderId);
            //确认订单
            if ("1".equals(orderState)) {
                foodOrder.setOrderState(OrderState.READY);
                baseResult.setMsg("已确认");
                baseResult.setFlag(true);
            }
            //派送中
            if ("2".equals(orderState)) {
                foodOrder.setOrderState(OrderState.ON_WAY);
                baseResult.setMsg("正在派送");
                baseResult.setFlag(true);
            }
            //已签收
            if ("3".equals(orderState)) {
                foodOrder.setOrderState(OrderState.OK);
                baseResult.setMsg("已签收");
                baseResult.setFlag(true);
            }
            //退订
            if ("4".equals(orderState)) {
                foodOrder.setOrderState(OrderState.BACK);
                baseResult.setMsg("退订成功");
                baseResult.setFlag(true);
            }
            try {
                orderServiceI.updateOrder(foodOrder);
            } catch (Exception e) {
                baseResult.setFlag(false);
                baseResult.setMsg("接口异常");
            }
            return baseResult;
        }
        return baseResult;
    }

    /**
     * 修改菜品状态
     */
    @ApiOperation(value = "修改菜品状态")
    @RequestMapping(value = "/fixFoodState.do", method = RequestMethod.POST)
    public BaseResult fixFoodState(String foodState, String foodId) {
        BaseResult baseResult = new BaseResult();
        if (StringUtils.isNotBlank(foodId)) {
            Food food = foodServiceI.getFoodById(foodId);
            //下架
            if ("0".equals(foodState)) {
                food.setFoodState(FoodState.UP);
                baseResult.setMsg("已上架");
                baseResult.setFlag(true);
            }
            //上架
            if ("1".equals(foodState)) {
                food.setFoodState(FoodState.DOWN);
                baseResult.setMsg("已下架");
                baseResult.setFlag(true);
            }
            try {
                foodServiceI.updateFood(food);
            } catch (Exception e) {
                baseResult.setFlag(false);
                baseResult.setMsg("接口异常");
            }
            return baseResult;
        }
        return baseResult;
    }

}
