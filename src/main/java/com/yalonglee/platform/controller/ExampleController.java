package com.yalonglee.platform.controller;

import com.yalonglee.common.base.Page;
import com.yalonglee.platform.entity.example.basic.Person;
import com.yalonglee.platform.service.example.ExampleServiceI;
import com.yalonglee.platform.vo.example.PersonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class ExampleController {
    @Autowired
    private ExampleServiceI exampleServiceI;

    /**
     * 新增
     *
     * @param person
     */
    @RequestMapping(value = "/save.do")
    public void save(@RequestBody Person person) {
        exampleServiceI.save(person);
    }

    /**
     * 删除
     *
     * @param person
     */
    @RequestMapping(value = "/delete.do")
    public void delete(@RequestBody Person person) {
        person = exampleServiceI.get(person.getId());
        exampleServiceI.delete(person);
    }

    /**
     * 更新
     *
     * @param person
     */
    @RequestMapping(value = "/update.do")
    public void update(@RequestBody Person person) {
        exampleServiceI.update(person);
    }

    /**
     * 更新或删除
     *
     * @param person
     */
    @RequestMapping(value = "/saveOrUpdate.do")
    public void saveOrUpdate(@RequestBody Person person) {
        exampleServiceI.saveOrUpdate(person);
    }

    /**
     * 通过ID获取实体类
     *
     * @param person
     * @return
     */
    @RequestMapping(value = "/get.do")
    public Person get(@RequestBody Person person) {
        return exampleServiceI.get(person.getId());
    }

    /**
     * 通过HQL获得一个VO
     */
    @RequestMapping(value = "/getVoByHql.do")
    public Object getVoByHql(String hql) {
        Object result = exampleServiceI.getVoByHql(PersonVo.class, hql);
        return result;
    }

    @RequestMapping(value = "/getVoBySql.do")
    public Object getVoBySql(String sql) {
        Object result = exampleServiceI.getVoBySql(PersonVo.class, sql);
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
     * 执行Hql语句获取VO集合
     */
    @RequestMapping(value = "/findVoListByHql.do")
    public List<Object> findVoListByHql(String hql) {
        List<Object> result = exampleServiceI.findVoListByHql(PersonVo.class, hql);
        return result;
    }

    @RequestMapping(value = "/findVoPageByHql.do")
    public Page<Object> findVoPageByHql(Page<Object> page, String hql) {
        Page<Object> result = exampleServiceI.findVoPageByHql(PersonVo.class, page, hql);
        return result;
    }

    /**
     * 执行原生Sql语句获取VO集合
     */
    @RequestMapping(value = "/findVoListBySql.do")
    public List<Object> findVoListBySql(String sql) {
        List<Object> result = exampleServiceI.findVoListBySql(PersonVo.class, sql);
        return result;
    }

    @RequestMapping(value = "/findVoPageBySql.do")
    public Page<Object> findVoPageBySql(Page<Object> page, String sql) {
        Page<Object> result = exampleServiceI.findVoPageBySql(PersonVo.class, page, sql);
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
