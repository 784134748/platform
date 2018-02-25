package com.iflytek.operation.controller;

import com.iflytek.operation.common.base.Page;
import com.iflytek.operation.dto.example.PersonDto;
import com.iflytek.operation.entity.example.basic.Person;
import com.iflytek.operation.service.example.ExampleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
@RestController
@RequestMapping(value = "/example")
public class ExampleController {
    @Autowired
    private ExampleServiceI exampleServiceI;

    @RequestMapping(value = "/save.do")
    public void save(@RequestBody Person person) {
        exampleServiceI.save(person);
    }

    @RequestMapping(value = "/delete.do")
    public void delete(@RequestBody Person person) {
        person = exampleServiceI.get(person.getId());
        exampleServiceI.delete(person);
    }

    @RequestMapping(value = "/update.do")
    public void update(@RequestBody Person person) {
        exampleServiceI.update(person);
    }

    @RequestMapping(value = "/saveOrUpdate.do")
    public void saveOrUpdate(@RequestBody Person person) {
        exampleServiceI.saveOrUpdate(person);
    }

    @RequestMapping(value = "/get.do")
    public Person get(@RequestBody Person person) {
        return exampleServiceI.get(person.getId());
    }

    /**
     * 通过HQL获得一个DTO
     */
    @RequestMapping(value = "/getDtoByHql.do")
    public Object getDtoByHql(String hql) {
        Object result = exampleServiceI.getDtoByHql(PersonDto.class, hql);
        return result;
    }

    @RequestMapping(value = "/getDtoBySql.do")
    public Object getDtoBySql(String sql) {
        Object result = exampleServiceI.getDtoBySql(PersonDto.class, sql);
        return result;
    }

    /**
     * 通过HQL获得一个对象
     */
    @RequestMapping(value = "/getObjectByHql.do")
    public Person getObjectByHql(String hql) {
        Person result = exampleServiceI.getEntityByHql(hql);
        return result;
    }

    @RequestMapping(value = "/getObjectBySql.do")
    public Person getObjectBySql(String sql) {
        Person result = exampleServiceI.getEntityBySql(sql);
        return result;
    }

    /**
     * 获取单个字段
     */
    @RequestMapping(value = "/getParamByHql.do")
    public List<Object> getParamByHql(String hql) {
        List<Object> result = exampleServiceI.getParamsByHql(hql);
        return result;
    }

    @RequestMapping(value = "/getParamBySql.do")
    public List<Object> getParamBySql(String sql) {
        List<Object> result = exampleServiceI.getParamsBySql(sql);
        return result;
    }

    /**
     * 获取多个字段
     */
    @RequestMapping(value = "/getParamsByHql.do")
    public List<Object[]> getParamsByHql(String hql) {
        List<Object[]> result = exampleServiceI.getParamsByHql(hql);
        return result;
    }

    @RequestMapping(value = "/getParamsBySql.do")
    public List<Object[]> getParamsBySql(String sql) {
        List<Object[]> result = exampleServiceI.getParamsBySql(sql);
        return result;
    }

    /**
     * 执行原生Hql语句
     */
    @RequestMapping(value = "/findListByHql.do")
    public List<Person> findListByHql(String hql) {
        List<Person> result = exampleServiceI.findListByHql(hql);
        return result;
    }

    @RequestMapping(value = "/findPageByHql.do")
    public Page<Person> findPageByHql(Page<Person> page, String hql) {
        Page<Person> result = exampleServiceI.findPageByHql(page, hql);
        return result;
    }

    /**
     * 执行原生Sql语句
     */
    @RequestMapping(value = "/findListBySql.do")
    public List<Person> findListBySql(String sql) {
        List<Person> result = exampleServiceI.findListBySql(sql);
        return result;
    }

    @RequestMapping(value = "/findPageBySql.do")
    public Page<Person> findPageBySql(Page<Person> page, String sql) {
        Page<Person> result = exampleServiceI.findPageBySql(page, sql);
        return result;
    }

    /**
     * 执行Hql语句获取DTO集合
     */
    @RequestMapping(value = "/findDtoListByHql.do")
    public List<Object> findDtoListByHql(String hql) {
        List<Object> result = exampleServiceI.findDtoListByHql(PersonDto.class, hql);
        return result;
    }

    @RequestMapping(value = "/findDtoPageByHql.do")
    public Page<Object> findDtoPageByHql(Page<Object> page, String hql) {
        Page<Object> result = exampleServiceI.findDtoPageByHql(PersonDto.class, page, hql);
        return result;
    }

    /**
     * 执行原生Sql语句获取DTO集合
     */
    @RequestMapping(value = "/findDtoListBySql.do")
    public List<Object> findDtoListBySql(String sql) {
        List<Object> result = exampleServiceI.findDtoListBySql(PersonDto.class, sql);
        return result;
    }

    @RequestMapping(value = "/findDtoPageBySql.do")
    public Page<Object> findDtoPageBySql(Page<Object> page, String sql) {
        Page<Object> result = exampleServiceI.findDtoPageBySql(PersonDto.class, page, sql);
        return result;
    }

    /**
     * 获得记录数
     */
    @RequestMapping(value = "/count.do")
    public Long count(String hql) {
        return exampleServiceI.count(hql);
    }

    /**
     * 执行HQL，返回状态
     */
    @RequestMapping(value = "/executeHql.do")
    public Integer executeHql(String hql) {
        return exampleServiceI.executeHql(hql);
    }

    /**
     * 执行SQL，返回状态
     */
    @RequestMapping(value = "/executeSql.do")
    public Integer executeSql(String sql) {
        return exampleServiceI.executeSql(sql);
    }

}
