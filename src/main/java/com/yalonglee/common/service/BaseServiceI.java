package com.yalonglee.common.service;

import com.yalonglee.common.base.Page;
import com.yalonglee.common.base.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2018/2/9]
 * @see [相关类/方法]
 */
public interface BaseServiceI<T> {
    /**
     * save
     *
     * @param o
     * @return
     */
    public Serializable save(T o);

    /**
     * delete
     *
     * @param o
     */
    public void delete(T o);

    /**
     * update
     *
     * @param o
     */
    public void update(T o);

    /**
     * saveOrUpdate
     *
     * @param o
     */
    public void saveOrUpdate(T o);

    /**
     * 通过ID获取一个对象
     *
     * @param id
     * @return
     */
    public T get(Serializable id);

    /**
     * 获取一个对象(懒加载)
     *
     * @param id
     * @return
     */
    public T load(Serializable id);

    /**
     * 通过HQL获得一个VO
     *
     * @param clazz
     * @param hql
     * @return
     */
    public <E> E getVoByHql(Class clazz, String hql);

    public <E> E getVoByHql(Class clazz, String hql, Object... params);

    public <E> E getVoByHql(Class clazz, String hql, List<Object> params);

    public <E> E getVoByHql(Class clazz, String hql, Map<String, Object> params);

    public <E> E getVoBySql(Class clazz, String sql);

    public <E> E getVoBySql(Class clazz, String sql, Object... params);

    public <E> E getVoBySql(Class clazz, String sql, List<Object> params);

    public <E> E getVoBySql(Class clazz, String sql, Map<String, Object> params);

    /**
     * 通过HQL获得一个对象
     *
     * @param hql
     * @return
     */
    public T getEntityByHql(String hql);

    public T getEntityByHql(String hql, Object... params);

    public T getEntityByHql(String hql, List<Object> params);

    public T getEntityByHql(String hql, Map<String, Object> params);

    public T getEntityBySql(String sql);

    public T getEntityBySql(String sql, Object... params);

    public T getEntityBySql(String sql, List<Object> params);

    public T getEntityBySql(String sql, Map<String, Object> params);

    /**
     * 获取单个/多个字段
     *
     * @param hql
     * @return
     */
    public <E> List<E> getParamsByHql(String hql);

    public <E> List<E> getParamsByHql(String hql, Object... params);

    public <E> List<E> getParamsByHql(String hql, List<Object> params);

    public <E> List<E> getParamsByHql(String hql, Map<String, Object> params);

    public <E> List<E> getParamsBySql(String sql);

    public <E> List<E> getParamsBySql(String sql, Object... params);

    public <E> List<E> getParamsBySql(String sql, List<Object> params);

    public <E> List<E> getParamsBySql(String sql, Map<String, Object> params);

    /**
     * 执行Hql语句
     *
     * @param hql
     * @return
     */
    public List<T> findListByHql(String hql);

    public List<T> findListByHql(String hql, Object... params);

    public List<T> findListByHql(String hql, List<Object> params);

    public List<T> findListByHql(String hql, Map<String, Object> params);

    public Page<T> findPageByHql(Page<T> page, String hql);

    public Page<T> findPageByHql(Page<T> page, String hql, Object... params);

    public Page<T> findPageByHql(Page<T> page, String hql, List<Object> params);

    public Page<T> findPageByHql(Page<T> page, String hql, Map<String, Object> params);

    /**
     * 执行原生Sql语句
     *
     * @param sql
     * @return
     */
    public List<T> findListBySql(String sql);

    public List<T> findListBySql(String sql, Object... params);

    public List<T> findListBySql(String sql, List<Object> params);

    public List<T> findListBySql(String sql, Map<String, Object> params);

    public Page<T> findPageBySql(Page<T> page, String sql);

    public Page<T> findPageBySql(Page<T> page, String sql, Object... params);

    public Page<T> findPageBySql(Page<T> page, String sql, List<Object> params);

    public Page<T> findPageBySql(Page<T> page, String sql, Map<String, Object> params);

    /**
     * 执行Hql语句获取VO集合
     *
     * @param clazz
     * @param hql
     * @return
     */
    public <E> List<E> findVoListByHql(Class clazz, String hql);

    public <E> List<E> findVoListByHql(Class clazz, String hql, Object... params);

    public <E> List<E> findVoListByHql(Class clazz, String hql, List<Object> params);

    public <E> List<E> findVoListByHql(Class clazz, String hql, Map<String, Object> params);

    public <E> Page<E> findVoPageByHql(Class clazz, Page<E> page, String hql);

    public <E> Page<E> findVoPageByHql(Class clazz, Page<E> page, String hql, Object... params);

    public <E> Page<E> findVoPageByHql(Class clazz, Page<E> page, String hql, List<Object> params);

    public <E> Page<E> findVoPageByHql(Class clazz, Page<E> page, String hql, Map<String, Object> params);

    /**
     * 执行原生Sql语句获取VO集合
     *
     * @param clazz
     * @param sql
     * @return
     */
    public <E> List<E> findVoListBySql(Class clazz, String sql);

    public <E> List<E> findVoListBySql(Class clazz, String sql, Object... params);

    public <E> List<E> findVoListBySql(Class clazz, String sql, List<Object> params);

    public <E> List<E> findVoListBySql(Class clazz, String sql, Map<String, Object> params);

    public <E> Page<E> findVoPageBySql(Class clazz, Page<E> page, String sql);

    public <E> Page<E> findVoPageBySql(Class clazz, Page<E> page, String sql, Object... params);

    public <E> Page<E> findVoPageBySql(Class clazz, Page<E> page, String sql, List<Object> params);

    public <E> Page<E> findVoPageBySql(Class clazz, Page<E> page, String sql, Map<String, Object> params);

    /**
     * 获得记录数
     *
     * @param hql
     * @return
     */
    public Long count(String hql);

    public Long count(String hql, Object... params);

    public Long count(String hql, List<Object> params);

    public Long count(String hql, Map<String, Object> params);

    /**
     * 执行SQL，返回状态
     *
     * @param hql
     * @return
     */
    public Integer executeHql(String hql);

    public Integer executeHql(String hql, Object... params);

    public Integer executeHql(String hql, List<Object> params);

    public Integer executeHql(String hql, Map<String, Object> params);

    /**
     * 执行SQL，返回状态
     *
     * @param sql
     * @return
     */
    public Integer executeSql(String sql);

    public Integer executeSql(String sql, Object... params);

    public Integer executeSql(String sql, List<Object> params);

    public Integer executeSql(String sql, Map<String, Object> params);
}
