package com.yalonglee.platform.controller.common;

import com.sun.org.apache.xpath.internal.operations.Mult;
import com.yalonglee.common.bean.BaseResult;
import com.yalonglee.common.bean.LayuiResult;
import com.yalonglee.common.bean.MultiResult;
import com.yalonglee.common.bean.dto.ResultRows;
import com.yalonglee.platform.dto.permission.*;
import com.yalonglee.platform.entity.example.basic.SexType;
import com.yalonglee.platform.entity.food.Restaurant;
import com.yalonglee.platform.entity.permission.*;
import com.yalonglee.platform.service.food.RestaurantServiceI;
import com.yalonglee.platform.service.permission.*;
import com.yalonglee.platform.vo.permission.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.PAData;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/17]
 * @see [相关类/方法]
 */
@Controller
@RequestMapping(value = "/rbac")
@Api(value = "基于RBAC的权限管理")
public class RbacController {

    @Autowired
    Mapper mapper;
    @Autowired
    private GroupServiceI groupServiceI;
    @Autowired
    private UserServiceI userServiceI;
    @Autowired
    private RoleServiceI roleServiceI;
    @Autowired
    private PermissionServiceI permissionServiceI;
    @Autowired
    private ResourceServiceI resourceServiceI;
    @Autowired
    private RestaurantServiceI restaurantServiceI;

    private static final Logger logger = LogManager.getLogger(RbacController.class);

    /**
     * 身份认证失败
     */
    @ApiOperation(value = "登录接口")
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public void toLoginPage(HttpServletRequest httpServletRequest) {
        String exceptionClassName = (String) httpServletRequest.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        if (StringUtils.isNotBlank(exceptionClassName)) {
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                System.out.println("用户名不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                System.out.println("密码错误");
            } else if (LockedAccountException.class.getName().equals(exceptionClassName)) {
                System.out.println("账户已锁定");
            } else {
                System.out.println("未知错误");
            }
        }
    }

    /**
     * 登录成功后重定向
     */
    @ApiOperation(value = "登录成功后重定向")
    @RequestMapping(value = "/successUrl.do")
    public String toSuccessPage() {
        Subject currentUser = SecurityUtils.getSubject();
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        roles.add("business");
        boolean[] toAdmin = currentUser.hasRoles(roles);
        for (boolean isTrue : toAdmin) {
            if (isTrue) {
                return "frame";
            }
        }
        return "main";
    }

    /**
     * 注册用户
     */
    @ApiOperation(value = "注册普通用户")
    @RequestMapping(value = "/register.do", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResult register(@RequestBody User user, @RequestParam String type, @RequestParam String sexType) {
        BaseResult result = new BaseResult();
        User user1 = userServiceI.getUserByUsername(user.getUsername());
        if ("perfect".equals(type)) {
            user1.setAddress(user.getAddress());
            user1.setNumber(user.getNumber());
            user1.setTelephone(user.getTelephone());
            if ("男".equals(sexType)) {
                user1.setSex(SexType.MAN);
            }
            if ("女".equals(sexType)) {
                user1.setSex(SexType.WOMAN);
            }
            try {
                userServiceI.saveOrUpdate(user1);
                result.setFlag(true);
                result.setMsg("完善成功");
                return result;
            } catch (Exception e) {
                result.setFlag(false);
                result.setMsg("接口异常");
                return result;
            }
        }
        if (null != user1) {
            result.setFlag(false);
            result.setMsg("当前用户已存在");
            return result;
        }
        Role role = roleServiceI.getRoleByRoleName("user");
        user.setSalt("1234");
        user.setLocked(AcountState.NORMOL);
        user.getRoles().add(role);
        userServiceI.saveOrUpdate(user);
        result.setFlag(true);
        result.setMsg("注册成功");
        return result;
    }

    /**
     * 创建管理员
     */
    @ApiOperation(value = "创建管理员")
    @RequestMapping(value = "/admin.do", method = RequestMethod.GET)
    public void superAdmin() {
        //创建管理员
        //创建权限
        Permission permission = new Permission();
        permission.setPermission("admin:admin:all");
        //创建角色
        Role role = new Role();
        role.setRole("admin");
        //创建用户
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setSalt("1234");
        //角色添加权限和群组
        role.getPermissions().add(permission);
        //用户添加角色和群组
        user.getRoles().add(role);

        //创建商家
        //创建权限
        Permission permission1 = new Permission();
        permission1.setPermission("business:business:all");
        //创建角色
        Role role1 = new Role();
        role1.setRole("business");
        //创建用户
        User user1 = new User();
        user1.setUsername("business");
        user1.setPassword("business");
        user1.setSalt("1234");
        //角色添加权限和群组
        role1.getPermissions().add(permission1);
        //用户添加角色和群组
        user1.getRoles().add(role1);

        //
        Restaurant restaurant = new Restaurant();
        restaurant.setBoss(user1);
        restaurant.setRestaurantName("business");

        //创建用户
        //创建权限
        Permission permission2 = new Permission();
        permission2.setPermission("user:user:all");
        //创建角色
        Role role2 = new Role();
        role2.setRole("user");
        //创建用户
        User user2 = new User();
        user2.setUsername("user");
        user2.setPassword("user");
        user2.setSalt("1234");
        //角色添加权限和群组
        role2.getPermissions().add(permission2);
        //用户添加角色和群组
        user2.getRoles().add(role2);

        //添加管理员
        userServiceI.saveOrUpdate(user);
        //添加商家
        userServiceI.saveOrUpdate(user1);
        //添加商户
        restaurantServiceI.addRestaurant(restaurant);
        //添加用户
        userServiceI.saveOrUpdate(user2);
    }

    /**
     * 新增/修改群组
     *
     * @param groupDto
     */
    @ApiOperation(value = "新增/修改群组")
    @RequestMapping(value = "/group", method = RequestMethod.PUT)
    @ResponseBody
    public void saveOrUpdateGroup(@RequestBody GroupDto groupDto) {
        Group group = new Group();
        mapper.map(groupDto, group);
        groupServiceI.saveOrUpdate(group);
    }

    /**
     * 新增/修改用户
     *
     * @param id
     * @param locked
     * @return
     */
    @ApiOperation(value = "新增/修改用户")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult saveOrUpdateUser(String id, Boolean locked) {
        BaseResult baseResult = new BaseResult();
        User user = userServiceI.get(id);
        if (true == locked) {
            user.setLocked(AcountState.LOCKED);
        }
        if (false == locked) {
            user.setLocked(AcountState.NORMOL);
        }

        try {
            userServiceI.saveOrUpdate(user);
        } catch (Exception e) {
            baseResult.setFlag(false);
            baseResult.setMsg("修改失败");
            return baseResult;
        }
        baseResult.setFlag(true);
        baseResult.setMsg("修改成功");
        return baseResult;
    }

    /**
     * 新增/修改角色
     *
     * @param roleDto
     */
    @ApiOperation(value = "新增/修改角色")
    @RequestMapping(value = "/role", method = RequestMethod.PUT)
    @ResponseBody
    public void saveOrUpdateRole(@RequestBody RoleDto roleDto) {
        Role role = new Role();
        mapper.map(roleDto, role);
        roleServiceI.saveOrUpdate(role);
    }

    /**
     * 新增/修改权限
     *
     * @param permissionDto
     */
    @ApiOperation(value = "新增/修改权限")
    @RequestMapping(value = "/permission", method = RequestMethod.PUT)
    @ResponseBody
    public void saveOrUpdatePermission(@RequestBody PermissionDto permissionDto) {
        Permission permission = new Permission();
        mapper.map(permissionDto, permission);
        permissionServiceI.saveOrUpdate(permission);
    }

    /**
     * 新增/修改资源
     *
     * @param resourceDto
     */
    @ApiOperation(value = "新增/修改资源")
    @RequestMapping(value = "/resource", method = RequestMethod.PUT)
    @ResponseBody
    public void saveOrUpdateResource(@RequestBody ResourceDto resourceDto) {
        Resource resource = new Resource();
        mapper.map(resource, resourceDto);
        resourceServiceI.saveOrUpdate(resource);
    }

    /**
     * 获取群组列表
     *
     * @param groupDto
     */
    @ApiOperation(value = "获取群组列表")
    @RequestMapping(value = "/group", method = RequestMethod.GET)
    @ResponseBody
    public void getGroups(GroupDto groupDto) {

    }

    /**
     * 获取用户列表
     *
     * @param userDto
     */
    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public LayuiResult<UserVo> getUsers(UserDto userDto, String username) {
        LayuiResult<UserVo> layuiResult = new LayuiResult<>();
        Map<String, Object> parames = new HashMap<>();
        if (StringUtils.isNotBlank(username)) {
            parames.put("username", username);
        }
        List<UserVo> list = userServiceI.getUsers(parames);
        layuiResult.setData(list);
        layuiResult.setCode(0);
        layuiResult.setCount(10L);
        return layuiResult;
    }

    /**
     * 获取角色列表
     *
     * @param roleDto
     */
    @ApiOperation(value = "获取角色列表")
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    @ResponseBody
    public void getRoles(RoleDto roleDto) {

    }

    /**
     * 获取权限列表
     *
     * @param permissionDto
     */
    @ApiOperation(value = "获取权限列表")
    @RequestMapping(value = "/permission", method = RequestMethod.GET)
    @ResponseBody
    public void getPermissions(PermissionDto permissionDto) {

    }

    /**
     * 获取资源列表
     *
     * @param resourceDto
     */
    @ApiOperation(value = "获取资源列表")
    @RequestMapping(value = "/resource", method = RequestMethod.GET)
    @ResponseBody
    public void getResources(ResourceDto resourceDto) {

    }

    /**
     * 群组与用户建立联系
     *
     * @param groupIds
     * @param userIds
     */
    @ApiOperation(value = "群组与用户建立联系")
    @RequestMapping(value = "/groups/users", method = RequestMethod.POST)
    public void groupsAndUsers(String groupIds, String userIds) {
        String[] groupId = groupIds.split(",");
        String[] userId = userIds.split(",");

    }

    /**
     * 群组与角色建立联系
     *
     * @param groupIds
     * @param roleIds
     */
    @ApiOperation(value = "群组与角色建立联系")
    @RequestMapping(value = "/groups/roles", method = RequestMethod.POST)
    public void groupsAndRoles(String groupIds, String roleIds) {
        String[] groupId = groupIds.split(",");
        String[] roleId = roleIds.split(",");

    }

    /**
     * 用户与角色建立联系
     *
     * @param userIds
     * @param roleIds
     */
    @ApiOperation(value = "用户与角色建立联系")
    @RequestMapping(value = "/users/roles", method = RequestMethod.POST)
    public void usersAndRoles(String userIds, String roleIds) {
        String[] userId = userIds.split(",");
        String[] roleId = roleIds.split(",");

    }

    /**
     * 角色与权限建立联系
     *
     * @param roleIds
     * @param permissionIds
     */
    @ApiOperation(value = "角色与权限建立联系")
    @RequestMapping(value = "/roles/permissions", method = RequestMethod.POST)
    public void rolesAndPermissions(String roleIds, String permissionIds) {
        String[] roleId = roleIds.split(",");
        String[] permissionId = permissionIds.split(",");
    }

    /**
     * 权限与资源建立联系
     *
     * @param permissionIds
     * @param resourceIds
     */
    @ApiOperation(value = "角色与权限建立联系")
    @RequestMapping(value = "/permissions/resources", method = RequestMethod.POST)
    public void permissionsAndResources(String permissionIds, String resourceIds) {
        String[] permissionId = permissionIds.split(",");
        String[] resourceId = resourceIds.split(",");

    }

}
