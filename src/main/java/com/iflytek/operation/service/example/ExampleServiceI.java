package com.iflytek.operation.service.example;

import com.iflytek.operation.common.base.Page;
import com.iflytek.operation.entity.example.Person;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

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
public interface ExampleServiceI {
    /**
     * save
     *
     * @param person
     * @return
     */
    public Serializable save(Person person);

    /**
     * delete
     *
     * @param person
     */
    public void delete(Person person);

    /**
     * update
     *
     * @param person
     */
    public void update(Person person);

    /**
     * saveOrUpdate
     *
     * @param person
     */
    public void saveOrUpdate(Person person);

    /**
     * 通过ID获取一个对象
     *
     * @param id
     * @return
     */
    public Person get(Serializable id);

    /**
     * 获取一个对象(懒加载)
     *
     * @param id
     * @return
     */
    public Person load(Serializable id);

    /**
     * 获得一个DTO
     *
     * @param hql
     * @return
     */
    public Object getDtoByHql(Class clazz, String hql);

    public Object getDtoBySql(Class clazz, String sql);

    /**
     * 获得一个对象
     *
     * @param hql
     * @return
     */
    public Person getEntityByHql(String hql);

    public Person getEntityBySql(String sql);

    /**
     * 获取单个字段
     *
     * @param hql
     * @return
     */
    public List<Object> getParamByHql(String hql);

    public List<Object> getParamBySql(String sql);

    /**
     * 获取多个字段
     *
     * @param hql
     * @return
     */
    public List<Object[]> getParamsByHql(String hql);

    public List<Object[]> getParamsBySql(String sql);

    /**
     * 执行原生Hql语句
     *
     * @param hql
     * @return
     */
    public List<Person> findListByHql(String hql);

    public Page<Person> findPageByHql(Page<Person> page, String hql);

    /**
     * 执行原生Sql语句
     *
     * @param sql
     * @return
     */
    public List<Person> findListBySql(String sql);

    public Page<Person> findPageBySql(Page<Person> page, String sql);

    /**
     * 执行Hql语句获取DTO集合
     *
     * @param hql
     * @return
     */
    public List<Object> findDtoListByHql(Class clazz, String hql);

    public Page<Object> findDtoPageByHql(Class clazz, Page<Object> page, String hql);

    /**
     * 执行原生Sql语句获取DTO集合
     *
     * @param sql
     * @return
     */
    public List<Object> findDtoListBySql(Class clazz, String sql);

    public Page<Object> findDtoPageBySql(Class clazz, Page<Object> page, String sql);

    /**
     * 获得记录数
     *
     * @param hql
     * @return
     */
    public Long count(String hql);

    /**
     * 执行HQL，返回状态
     *
     * @param hql
     * @return
     */
    public Integer executeHql(String hql);

    /**
     * 执行SQL，返回状态
     *
     * @param sql
     * @return
     */
    public Integer executeSql(String sql);

    /**
     * 创建sql查询
     *
     * @param sql
     * @return
     */
    public SQLQuery createSqlQuery(String sql);

    public SQLQuery createSqlQuery(Class clazz, String sql);

    public SQLQuery createSqlQuery(Page<Person> page, String sql);

    public SQLQuery createSqlQuery(Class clazz, Page<?> page, String sql);

    /**
     * 创建hql查询
     *
     * @param hql
     * @return
     */
    public Query createQuery(String hql);

    public Query createQuery(Class clazz, String hql);

    public Query createQuery(Page<Person> page, String hql);

    public Query createQuery(Class clazz, Page<?> page, String hql);

}
