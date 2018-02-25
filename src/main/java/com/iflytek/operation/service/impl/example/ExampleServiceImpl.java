package com.iflytek.operation.service.impl.example;

import com.iflytek.operation.common.service.impl.BaseServiceImpl;
import com.iflytek.operation.entity.example.basic.Person;
import com.iflytek.operation.service.example.ExampleServiceI;
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
public class ExampleServiceImpl extends BaseServiceImpl<Person> implements ExampleServiceI {

}
