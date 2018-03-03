package com.yalonglee.platform.service.impl.permission;

import com.yalonglee.platform.entity.permission.Permission;
import com.yalonglee.platform.entity.permission.Role;
import com.yalonglee.platform.entity.permission.User;
import com.yalonglee.platform.service.permission.RoleServiceI;
import com.yalonglee.platform.service.permission.UserServiceI;
import com.yalonglee.platform.service.permission.RoleServiceI;
import com.yalonglee.platform.service.permission.UserServiceI;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* UserServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>一月 8, 2018</pre> 
* @version 1.0 
*/ 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
//@Transactional
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class UserServiceImplTest { 
    @Autowired
    private UserServiceI userServiceI;
    @Autowired
    private RoleServiceI roleServiceI;

    //TODO Test Controller
    //private MockHttpServletRequest request;
    //private MockHttpServletResponse response;
    
    //TODO Test mybaties
    //private static ApplicationContext ctx;
    //private static SqlSessionFactory sqlSessionFactory;
    //private static SqlSession sqlSession;
    
@Before
public void before() throws Exception {

    //TODO Test Controller
    //request = new MockHttpServletRequest();
    //response = new MockHttpServletResponse();
    //request.setCharacterEncoding("UTF-8");
    
    //TODO Test mybaties
    //ctx= new ClassPathXmlApplicationContext("classpath*:spring-config.xml");
    //sqlSessionFactory = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");
    //sqlSession = sqlSessionFactory.openSession();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: get(Serializable id) 
* 
*/ 
@Test
public void testGet() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getUserByUsername(String username) 
* 
*/ 
@Test
public void testGetUserByUsername() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: saveOrUpdate(User user) 
* 
*/ 
@Test
public void testSaveOrUpdate() throws Exception {
    //创建权限
    Permission permission1 = new Permission();
    permission1.setPermission("admin:admin:all");
    Permission permission2 = new Permission();
    permission2.setPermission("admin1:admin1:all");
    //创建角色
    Role role1 = new Role();
    role1.setRole("admin");
    Role role2 = new Role();
    role2.setRole("admin1");
    //创建用户
    User user = new User();
    user.setUsername("admin");
    user.setPassword("123456");
    user.setSalt("1234");
    User user1 = new User();
    user1.setUsername("admin1");
    user1.setPassword("123456");
    user1.setSalt("1234");
    //角色添加权限
    role1.getPermissions().add(permission1);
    role1.getPermissions().add(permission2);
    role2.getPermissions().add(permission1);
    role2.getPermissions().add(permission2);
    //用户添加角色
    user.getRoles().add(role1);
    user.getRoles().add(role2);
    user1.getRoles().add(role1);
    user1.getRoles().add(role2);
    //向数据库正向级联插入用户
    userServiceI.saveOrUpdate(user);
    userServiceI.saveOrUpdate(user1);
} 

/** 
* 
* Method: delete(User user) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
    User user1 = userServiceI.get(21L);
//    User user2 = userServiceI.get(14L);
    userServiceI.delete(user1);
//    userServiceI.delete(user2);
}


} 
