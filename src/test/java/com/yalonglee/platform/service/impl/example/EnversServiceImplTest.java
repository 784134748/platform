package com.yalonglee.platform.service.impl.example;

import com.yalonglee.platform.entity.example.envers.Customer;
import com.yalonglee.platform.service.example.EnversServiceI;
import com.yalonglee.platform.service.example.EnversServiceI;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* EnversServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>二月 9, 2018</pre> 
* @version 1.0 
*/ 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext.xml"})
//@Transactional
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class EnversServiceImplTest { 
    @Autowired
    // TODO autowired goes here...
    private EnversServiceI enversServiceI;

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
* Method: save(Customer customer) 
* 
*/ 
@Test
public void testSave() throws Exception {
    Customer customer = new Customer();
    customer.setFirstName( "John" );
    customer.setLastName( "Doe" );
    enversServiceI.save(customer);
} 

/** 
* 
* Method: delete(Customer customer) 
* 
*/ 
@Test
public void testDelete() throws Exception {
    Customer customer = enversServiceI.getEntityByHql("from Customer a where a.firstName = 'John'");
    Customer customer_del = enversServiceI.get(customer.getId());
    enversServiceI.delete(customer_del);
} 

/** 
* 
* Method: update(Customer customer) 
* 
*/ 
@Test
public void testUpdate() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: saveOrUpdate(Customer customer) 
* 
*/ 
@Test
public void testSaveOrUpdate() throws Exception { 
//TODO: Test goes here... 
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
* Method: load(Serializable id) 
* 
*/ 
@Test
public void testLoad() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getDtoByHql(Class clazz, String hql) 
* 
*/ 
@Test
public void testGetDtoByHql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getDtoBySql(Class clazz, String sql) 
* 
*/ 
@Test
public void testGetDtoBySql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getEntityByHql(String hql) 
* 
*/ 
@Test
public void testGetEntityByHql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getEntityBySql(String sql) 
* 
*/ 
@Test
public void testGetEntityBySql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getParamByHql(String hql) 
* 
*/ 
@Test
public void testGetParamByHql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getParamBySql(String sql) 
* 
*/ 
@Test
public void testGetParamBySql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getParamsByHql(String hql) 
* 
*/ 
@Test
public void testGetParamsByHql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getParamsBySql(String sql) 
* 
*/ 
@Test
public void testGetParamsBySql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findListByHql(String hql) 
* 
*/ 
@Test
public void testFindListByHql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findPageByHql(Page<Customer> page, String hql) 
* 
*/ 
@Test
public void testFindPageByHql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findListBySql(String sql) 
* 
*/ 
@Test
public void testFindListBySql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findPageBySql(Page<Customer> page, String sql) 
* 
*/ 
@Test
public void testFindPageBySql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findDtoListByHql(Class clazz, String hql) 
* 
*/ 
@Test
public void testFindDtoListByHql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findDtoPageByHql(Class clazz, Page<Object> page, String hql) 
* 
*/ 
@Test
public void testFindDtoPageByHql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findDtoListBySql(Class clazz, String sql) 
* 
*/ 
@Test
public void testFindDtoListBySql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findDtoPageBySql(Class clazz, Page<Object> page, String sql) 
* 
*/ 
@Test
public void testFindDtoPageBySql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: count(String hql) 
* 
*/ 
@Test
public void testCount() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: executeHql(String hql) 
* 
*/ 
@Test
public void testExecuteHql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: executeSql(String sql) 
* 
*/ 
@Test
public void testExecuteSql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: createNativeQuery(String sql) 
* 
*/ 
@Test
public void testCreateNativeQuerySql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: createNativeQuery(Class clazz, String sql) 
* 
*/ 
@Test
public void testCreateNativeQueryForClazzSql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: createNativeQuery(Page<Customer> page, String sql) 
* 
*/ 
@Test
public void testCreateNativeQueryForPageSql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: createNativeQuery(Class clazz, Page<?> page, String sql) 
* 
*/ 
@Test
public void testCreateNativeQueryForClazzPageSql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: createQuery(String hql) 
* 
*/ 
@Test
public void testCreateQueryHql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: createQuery(Class clazz, String hql) 
* 
*/ 
@Test
public void testCreateQueryForClazzHql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: createQuery(Page<Customer> page, String hql) 
* 
*/ 
@Test
public void testCreateQueryForPageHql() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: createQuery(Class clazz, Page<?> page, String hql) 
* 
*/ 
@Test
public void testCreateQueryForClazzPageHql() throws Exception { 
//TODO: Test goes here... 
} 


} 
