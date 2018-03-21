package com.yalonglee.platform.service.impl.permission;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* PermissionServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>一月 8, 2018</pre> 
* @version 1.0 
*/ 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
//@Transactional
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class PermissionServiceImplTest { 
    @Autowired
    // TODO autowired goes here...

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
* Method: getPermissionsByUid(Long id) 
* 
*/ 
@Test
public void testGetPermissionsByUid() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: saveOrUpdate(PermissionDto permission)
* 
*/ 
@Test
public void testSaveOrUpdate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: delete(PermissionDto permission)
* 
*/ 
@Test
public void testDelete() throws Exception { 
//TODO: Test goes here... 
} 


} 
