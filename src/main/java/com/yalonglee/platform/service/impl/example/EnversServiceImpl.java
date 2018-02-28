package com.yalonglee.platform.service.impl.example;

import com.yalonglee.common.service.impl.BaseServiceImpl;
import com.yalonglee.platform.entity.example.envers.Customer;
import com.yalonglee.platform.service.example.EnversServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
@Transactional(rollbackFor = Exception.class)
public class EnversServiceImpl extends BaseServiceImpl<Customer> implements EnversServiceI {

}
