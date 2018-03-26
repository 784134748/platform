package com.yalonglee.platform.controller;

import com.yalonglee.common.base.Page;
import com.yalonglee.platform.dto.example.PersonDto;
import com.yalonglee.platform.entity.example.basic.Person;
import com.yalonglee.platform.service.example.ExampleServiceI;
import com.yalonglee.platform.vo.example.PersonVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/10]
 * @see [相关类/方法]
 */
@RestController
@EnableWebMvc
@RequestMapping(value = "/example")
@Api(value = "Hibernate基础Dao层接口测试")
public class ExampleController {

    @Autowired
    Mapper mapper;
    @Autowired
    private ExampleServiceI exampleServiceI;

    /**
     * 新增
     *
     * @param personDto
     */
    @ApiOperation(value = "新增")
    @RequestMapping(value = "/save.do", method = RequestMethod.PUT)
    public void save(@RequestBody PersonDto personDto) {
        Person person = new Person();
        mapper.map(personDto, person);
        exampleServiceI.save(person);
    }

    /**
     * 删除
     *
     * @param personDto
     */
    @ApiOperation(value = "删除")
    @RequestMapping(value = "/delete.do", method = RequestMethod.DELETE)
    public void delete(@RequestBody PersonDto personDto) {
        Person person = exampleServiceI.get(personDto.getId());
        exampleServiceI.delete(person);
    }

    /**
     * 更新
     *
     * @param personDto
     */
    @ApiOperation(value = "更新")
    @RequestMapping(value = "/update.do", method = RequestMethod.PUT)
    public void update(@RequestBody PersonDto personDto) {
        Person person = exampleServiceI.get(personDto.getId());
        mapper.map(personDto, person);
        exampleServiceI.update(person);
    }

    /**
     * 更新或删除
     *
     * @param personDto
     */
    @ApiOperation(value = "更新或删除")
    @RequestMapping(value = "/saveOrUpdate.do", method = RequestMethod.PUT)
    public void saveOrUpdate(@RequestBody PersonDto personDto) {
        Person person = exampleServiceI.get(personDto.getId());
        mapper.map(personDto, person);
        exampleServiceI.saveOrUpdate(person);
    }

    /**
     * 通过ID获取实体类
     *
     * @param personDto
     * @return
     */
    @ApiOperation(value = "通过ID获取实体类")
    @RequestMapping(value = "/get.do", method = RequestMethod.GET)
    public Person get(@RequestBody PersonDto personDto) {
        return exampleServiceI.get(personDto.getId());
    }

    /**
     * 通过HQL获得一个VO
     */
    @ApiOperation(value = "通过HQL获得一个VO")
    @RequestMapping(value = "/getVoByHql.do", method = RequestMethod.GET)
    public Object getVoByHql(String hql) {
        Object result = exampleServiceI.getVoByHql(PersonVo.class, hql);
        return result;
    }

    /**
     * 通过SQL获得一个VO
     */
    @ApiOperation(value = "通过SQL获得一个VO")
    @RequestMapping(value = "/getVoBySql.do", method = RequestMethod.GET)
    public Object getVoBySql(String sql) {
        Object result = exampleServiceI.getVoBySql(PersonVo.class, sql);
        return result;
    }

    /**
     * 通过HQL获得一个对象
     */
    @ApiOperation(value = "通过HQL获得一个对象")
    @RequestMapping(value = "/getObjectByHql.do", method = RequestMethod.GET)
    public Person getObjectByHql(String hql) {
        Person result = exampleServiceI.getEntityByHql(hql);
        return result;
    }

    /**
     * 通过SQL获得一个对象
     */
    @ApiOperation(value = "通过SQL获得一个对象")
    @RequestMapping(value = "/getObjectBySql.do", method = RequestMethod.GET)
    public Person getObjectBySql(String sql) {
        Person result = exampleServiceI.getEntityBySql(sql);
        return result;
    }

    /**
     * 通过HQL获取单个字段
     */
    @ApiOperation(value = "通过HQL获取单个字段")
    @RequestMapping(value = "/getParamByHql.do", method = RequestMethod.GET)
    public List<Object> getParamByHql(String hql) {
        List<Object> result = exampleServiceI.getParamsByHql(hql);
        return result;
    }

    /**
     * 通过SQL获取单个字段
     */
    @ApiOperation(value = "通过SQL获取单个字段")
    @RequestMapping(value = "/getParamBySql.do", method = RequestMethod.GET)
    public List<Object> getParamBySql(String sql) {
        List<Object> result = exampleServiceI.getParamsBySql(sql);
        return result;
    }

    /**
     * 通过HQL获取多个字段集合
     */
    @ApiOperation(value = "通过HQL获取多个字段")
    @RequestMapping(value = "/getParamsByHql.do", method = RequestMethod.GET)
    public List<Object[]> getParamsByHql(String hql) {
        List<Object[]> result = exampleServiceI.getParamsByHql(hql);
        return result;
    }

    /**
     * 通过SQL获取多个字段集合
     */
    @ApiOperation(value = "通过SQL获取多个字段")
    @RequestMapping(value = "/getParamsBySql.do", method = RequestMethod.GET)
    public List<Object[]> getParamsBySql(String sql) {
        List<Object[]> result = exampleServiceI.getParamsBySql(sql);
        return result;
    }

    /**
     * 执行原生Hql语句获取List
     */
    @ApiOperation(value = "执行原生Hql语句获取List")
    @RequestMapping(value = "/findListByHql.do", method = RequestMethod.GET)
    public List<Person> findListByHql(String hql) {
        List<Person> result = exampleServiceI.findListByHql(hql);
        return result;
    }

    /**
     * 执行原生Hql语句获取Page
     */
    @ApiOperation(value = "执行原生Hql语句获取Page")
    @RequestMapping(value = "/findPageByHql.do", method = RequestMethod.GET)
    public Page<Person> findPageByHql(Page<Person> page, String hql) {
        Page<Person> result = exampleServiceI.findPageByHql(page, hql);
        return result;
    }

    /**
     * 执行原生Sql语句获取List
     */
    @ApiOperation(value = "执行原生Sql语句获取List")
    @RequestMapping(value = "/findListBySql.do", method = RequestMethod.GET)
    public List<Person> findListBySql(String sql) {
        List<Person> result = exampleServiceI.findListBySql(sql);
        return result;
    }

    /**
     * 执行原生Sql语句获取Page
     */
    @ApiOperation(value = "执行原生Sql语句获取Page")
    @RequestMapping(value = "/findPageBySql.do", method = RequestMethod.GET)
    public Page<Person> findPageBySql(Page<Person> page, String sql) {
        Page<Person> result = exampleServiceI.findPageBySql(page, sql);
        return result;
    }

    /**
     * 执行Hql语句获取VO-List
     */
    @ApiOperation(value = "执行Hql语句获取VO-List")
    @RequestMapping(value = "/findVoListByHql.do", method = RequestMethod.GET)
    public List<Object> findVoListByHql(String hql) {
        List<Object> result = exampleServiceI.findVoListByHql(PersonVo.class, hql);
        return result;
    }

    /**
     * 执行Hql语句获取VO-Page
     */
    @ApiOperation(value = "执行Hql语句获取VO-Page")
    @RequestMapping(value = "/findVoPageByHql.do", method = RequestMethod.GET)
    public Page<Object> findVoPageByHql(Page<Object> page, String hql) {
        Page<Object> result = exampleServiceI.findVoPageByHql(PersonVo.class, page, hql);
        return result;
    }

    /**
     * 执行原生Sql语句获取VO-List
     */
    @ApiOperation(value = "执行原生Sql语句获取VO-List")
    @RequestMapping(value = "/findVoListBySql.do", method = RequestMethod.GET)
    public List<Object> findVoListBySql(String sql) {
        List<Object> result = exampleServiceI.findVoListBySql(PersonVo.class, sql);
        return result;
    }

    /**
     * 执行原生Sql语句获取VO-Page
     */
    @ApiOperation(value = "执行原生Sql语句获取VO-Page")
    @RequestMapping(value = "/findVoPageBySql.do", method = RequestMethod.GET)
    public Page<Object> findVoPageBySql(Page<Object> page, String sql) {
        Page<Object> result = exampleServiceI.findVoPageBySql(PersonVo.class, page, sql);
        return result;
    }

    /**
     * 获得记录数
     */
    @ApiOperation(value = "获得记录数")
    @RequestMapping(value = "/count.do", method = RequestMethod.GET)
    public Long count(String hql) {
        return exampleServiceI.count(hql);
    }

    /**
     * 执行HQL，返回状态
     */
    @ApiOperation(value = "执行HQL，返回状态")
    @RequestMapping(value = "/executeHql.do", method = RequestMethod.GET)
    public Integer executeHql(String hql) {
        return exampleServiceI.executeHql(hql);
    }

    /**
     * 执行SQL，返回状态
     */
    @ApiOperation(value = "执行SQL，返回状态")
    @RequestMapping(value = "/executeSql.do", method = RequestMethod.GET)
    public Integer executeSql(String sql) {
        return exampleServiceI.executeSql(sql);
    }

}
