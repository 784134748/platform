package com.iflytek.operation.service.impl.permission; 

import com.iflytek.operation.entity.permission.Permission;
import com.iflytek.operation.entity.permission.Role;
import com.iflytek.operation.entity.permission.User;
import com.iflytek.operation.service.permission.UserServiceI;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    // TODO autowired goes here...
    private UserServiceI userServiceI;

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
    permission1.setPermission("admin1:admin1:all");
    Permission permission2 = new Permission();
    permission2.setPermission("admin2:admin2:all");
    //创建角色
    Role role1 = new Role();
    role1.setRole("admin1");
    Role role2 = new Role();
    role2.setRole("admin2");
    //创建用户
    User user1 = new User();
    user1.setUsername("admin9");
    user1.setPassword("123456");
    user1.setSalt("1234");
    User user2 = new User();
    user2.setUsername("admin10");
    user2.setPassword("123456");
    user2.setSalt("1234");
    //用户、角色、权限集合
    List<Role> roles = new ArrayList<>(2);
    List<Permission> permissions = new ArrayList<>(2);
    roles.add(role1);
    roles.add(role2);
    permissions.add(permission1);
    permissions.add(permission2);
    //用户添加角色和权限
    role1.setPermissions(permissions);
    role2.setPermissions(permissions);
    user1.setRoles(roles);
    user2.setRoles(roles);
    //向数据库级联插入数据
    userServiceI.save(user1);
    userServiceI.save(user2);
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
