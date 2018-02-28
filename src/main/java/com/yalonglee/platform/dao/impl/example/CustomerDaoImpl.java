package com.yalonglee.platform.dao.impl.example;

import com.yalonglee.common.dao.impl.BaseDaoImpl;
import com.yalonglee.platform.dao.example.CustomerDaoI;
import com.yalonglee.platform.entity.example.envers.Customer;
import org.springframework.stereotype.Repository;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/10]
 * @see [相关类/方法]
 */
@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDaoI {
}
