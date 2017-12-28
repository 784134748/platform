package com.iflytek.operation.service.impl.example;

import com.iflytek.operation.common.base.Page;
import com.iflytek.operation.dao.example.ExampleDaoI;
import com.iflytek.operation.entity.example.Person;
import com.iflytek.operation.service.example.ExampleServiceI;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
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
@Service
@Transactional(rollbackFor = Exception.class)
public class ExampleServiceImpl implements ExampleServiceI {

    @Autowired
    private ExampleDaoI exampleDaoI;

    @Override
    public Serializable save(Person person) {
        return exampleDaoI.save(person);
    }

    @Override
    public void delete(Person person) {
        exampleDaoI.delete(person);
    }

    @Override
    public void update(Person person) {
        exampleDaoI.update(person);
    }

    @Override
    public void saveOrUpdate(Person person) {
        exampleDaoI.saveOrUpdate(person);
    }

    @Override
    public Person get(Serializable id) {
        return exampleDaoI.get(id);
    }

    @Override
    public Person load(Serializable id) {
        return exampleDaoI.load(id);
    }

    @Override
    public Object getDtoByHql(Class clazz, String hql) {
        return exampleDaoI.getDtoByHql(clazz, hql);
    }

    @Override
    public Object getDtoBySql(Class clazz, String sql) {
        return exampleDaoI.getDtoBySql(clazz, sql);
    }

    @Override
    public Person getEntityByHql(String hql) {
        return exampleDaoI.getEntityByHql(hql);
    }

    @Override
    public Person getEntityBySql(String sql) {
        return exampleDaoI.getEntityBySql(sql);
    }

    @Override
    public List<Object> getParamByHql(String hql) {
        return exampleDaoI.getParamsByHql(hql);
    }

    @Override
    public List<Object> getParamBySql(String sql) {
        return exampleDaoI.getParamsBySql(sql);
    }

    @Override
    public List<Object[]> getParamsByHql(String hql) {
        return exampleDaoI.getParamsByHql(hql);
    }

    @Override
    public List<Object[]> getParamsBySql(String sql) {
        return exampleDaoI.getParamsBySql(sql);
    }

    @Override
    public List<Person> findListByHql(String hql) {
        return exampleDaoI.findListByHql(hql);
    }

    @Override
    public Page<Person> findPageByHql(Page<Person> page, String hql) {
        return exampleDaoI.findPageByHql(page, hql);
    }

    @Override
    public List<Person> findListBySql(String sql) {
        return exampleDaoI.findListBySql(sql);
    }

    @Override
    public Page<Person> findPageBySql(Page<Person> page, String sql) {
        return exampleDaoI.findPageBySql(page, sql);
    }

    @Override
    public List<Object> findDtoListByHql(Class clazz, String hql) {
        return (List<Object>) exampleDaoI.findDtoListByHql(clazz, hql);
    }

    @Override
    public Page<Object> findDtoPageByHql(Class clazz, Page<Object> page, String hql) {
        return (Page<Object>) exampleDaoI.findDtoPageByHql(clazz, page, hql);
    }

    @Override
    public List<Object> findDtoListBySql(Class clazz, String sql) {
        return (List<Object>) exampleDaoI.findDtoListBySql(clazz, sql);
    }

    @Override
    public Page<Object> findDtoPageBySql(Class clazz, Page<Object> page, String sql) {
        return (Page<Object>) exampleDaoI.findDtoPageBySql(clazz, page, sql);
    }

    @Override
    public Long count(String hql) {
        return exampleDaoI.count(hql);
    }

    @Override
    public Integer executeHql(String hql) {
        return exampleDaoI.executeHql(hql);
    }

    @Override
    public Integer executeSql(String sql) {
        return exampleDaoI.executeSql(sql);
    }

    @Override
    public SQLQuery createSqlQuery(String sql) {
        return exampleDaoI.createSqlQuery(sql);
    }

    @Override
    public SQLQuery createSqlQuery(Class clazz, String sql) {
        return exampleDaoI.createSqlQuery(clazz, sql);
    }

    @Override
    public SQLQuery createSqlQuery(Page<Person> page, String sql) {
        return exampleDaoI.createSqlQuery(page, sql);
    }

    @Override
    public SQLQuery createSqlQuery(Class clazz, Page<?> page, String sql) {
        return exampleDaoI.createSqlQuery(clazz, page, sql);
    }

    @Override
    public Query createQuery(String hql) {
        return exampleDaoI.createSqlQuery(hql);
    }

    @Override
    public Query createQuery(Class clazz, String hql) {
        return exampleDaoI.createSqlQuery(clazz, hql);
    }

    @Override
    public Query createQuery(Page<Person> page, String hql) {
        return exampleDaoI.createSqlQuery(page, hql);
    }

    @Override
    public Query createQuery(Class clazz, Page<?> page, String hql) {
        return exampleDaoI.createSqlQuery(clazz, page, hql);
    }

}
