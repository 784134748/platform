package com.yalonglee.common.service.impl;

import com.yalonglee.common.base.Page;
import com.yalonglee.common.dao.BaseDaoI;
import com.yalonglee.common.service.BaseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2018/2/9]
 * @see [相关类/方法]
 */
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T> implements BaseServiceI<T> {

    @Autowired
    private BaseDaoI<T> baseDaoI;

    @Override
    public Serializable save(T o) {
        return baseDaoI.save(o);
    }

    @Override
    public void delete(T o) {
        baseDaoI.delete(o);
    }

    @Override
    public void update(T o) {
        baseDaoI.update(o);
    }

    @Override
    public void saveOrUpdate(T o) {
        baseDaoI.saveOrUpdate(o);
    }

    @Override
    public T get(Serializable id) {
        return baseDaoI.get(id);
    }

    @Override
    public T load(Serializable id) {
        return baseDaoI.load(id);
    }

    @Override
    public <E> E getVoByHql(Class clazz, String hql) {
        return baseDaoI.getVoByHql(clazz, hql);
    }

    @Override
    public <E> E getVoByHql(Class clazz, String hql, Object... params) {
        return baseDaoI.getVoByHql(clazz, hql, params);
    }

    @Override
    public <E> E getVoByHql(Class clazz, String hql, List<Object> params) {
        return baseDaoI.getVoByHql(clazz, hql, params);
    }

    @Override
    public <E> E getVoByHql(Class clazz, String hql, Map<String, Object> params) {
        return baseDaoI.getVoByHql(clazz, hql, params);
    }

    @Override
    public <E> E getVoBySql(Class clazz, String sql) {
        return baseDaoI.getVoBySql(clazz, sql);
    }

    @Override
    public <E> E getVoBySql(Class clazz, String sql, Object... params) {
        return baseDaoI.getVoBySql(clazz, sql, params);
    }

    @Override
    public <E> E getVoBySql(Class clazz, String sql, List<Object> params) {
        return baseDaoI.getVoBySql(clazz, sql, params);
    }

    @Override
    public <E> E getVoBySql(Class clazz, String sql, Map<String, Object> params) {
        return baseDaoI.getVoBySql(clazz, sql, params);
    }

    @Override
    public T getEntityByHql(String hql) {
        return baseDaoI.getEntityByHql(hql);
    }

    @Override
    public T getEntityByHql(String hql, Object... params) {
        return baseDaoI.getEntityByHql(hql, params);
    }

    @Override
    public T getEntityByHql(String hql, List<Object> params) {
        return baseDaoI.getEntityByHql(hql, params);
    }

    @Override
    public T getEntityByHql(String hql, Map<String, Object> params) {
        return baseDaoI.getEntityByHql(hql, params);
    }

    @Override
    public T getEntityBySql(String sql) {
        return baseDaoI.getEntityBySql(sql);
    }

    @Override
    public T getEntityBySql(String sql, Object... params) {
        return baseDaoI.getEntityBySql(sql, params);
    }

    @Override
    public T getEntityBySql(String sql, List<Object> params) {
        return baseDaoI.getEntityBySql(sql, params);
    }

    @Override
    public T getEntityBySql(String sql, Map<String, Object> params) {
        return baseDaoI.getEntityBySql(sql, params);
    }

    @Override
    public <E> List<E> getParamsByHql(String hql) {
        return baseDaoI.getParamsByHql(hql);
    }

    @Override
    public <E> List<E> getParamsByHql(String hql, Object... params) {
        return baseDaoI.getParamsByHql(hql, params);
    }

    @Override
    public <E> List<E> getParamsByHql(String hql, List<Object> params) {
        return baseDaoI.getParamsByHql(hql, params);
    }

    @Override
    public <E> List<E> getParamsByHql(String hql, Map<String, Object> params) {
        return baseDaoI.getParamsByHql(hql, params);
    }

    @Override
    public <E> List<E> getParamsBySql(String sql) {
        return baseDaoI.getParamsBySql(sql);
    }

    @Override
    public <E> List<E> getParamsBySql(String sql, Object... params) {
        return baseDaoI.getParamsBySql(sql, params);
    }

    @Override
    public <E> List<E> getParamsBySql(String sql, List<Object> params) {
        return baseDaoI.getParamsBySql(sql, params);
    }

    @Override
    public <E> List<E> getParamsBySql(String sql, Map<String, Object> params) {
        return baseDaoI.getParamsBySql(sql, params);
    }

    @Override
    public List<T> findListByHql(String hql) {
        return baseDaoI.findListByHql(hql);
    }

    @Override
    public List<T> findListByHql(String hql, Object... params) {
        return baseDaoI.findListByHql(hql, params);
    }

    @Override
    public List<T> findListByHql(String hql, List<Object> params) {
        return baseDaoI.findListByHql(hql, params);
    }

    @Override
    public List<T> findListByHql(String hql, Map<String, Object> params) {
        return baseDaoI.findListByHql(hql, params);
    }

    @Override
    public Page<T> findPageByHql(Page<T> page, String hql) {
        return baseDaoI.findPageByHql(page, hql);
    }

    @Override
    public Page<T> findPageByHql(Page<T> page, String hql, Object... params) {
        return baseDaoI.findPageByHql(page, hql, params);
    }

    @Override
    public Page<T> findPageByHql(Page<T> page, String hql, List<Object> params) {
        return baseDaoI.findPageByHql(page, hql, params);
    }

    @Override
    public Page<T> findPageByHql(Page<T> page, String hql, Map<String, Object> params) {
        return baseDaoI.findPageByHql(page, hql, params);
    }

    @Override
    public List<T> findListBySql(String sql) {
        return baseDaoI.findListBySql(sql);
    }

    @Override
    public List<T> findListBySql(String sql, Object... params) {
        return baseDaoI.findListBySql(sql, params);
    }

    @Override
    public List<T> findListBySql(String sql, List<Object> params) {
        return baseDaoI.findListBySql(sql, params);
    }

    @Override
    public List<T> findListBySql(String sql, Map<String, Object> params) {
        return baseDaoI.findListBySql(sql, params);
    }

    @Override
    public Page<T> findPageBySql(Page<T> page, String sql) {
        return baseDaoI.findPageBySql(page, sql);
    }

    @Override
    public Page<T> findPageBySql(Page<T> page, String sql, Object... params) {
        return baseDaoI.findPageBySql(page, sql, params);
    }

    @Override
    public Page<T> findPageBySql(Page<T> page, String sql, List<Object> params) {
        return baseDaoI.findPageBySql(page, sql, params);
    }

    @Override
    public Page<T> findPageBySql(Page<T> page, String sql, Map<String, Object> params) {
        return baseDaoI.findPageBySql(page, sql, params);
    }

    @Override
    public <E> List<E> findVoListByHql(Class clazz, String hql) {
        return baseDaoI.findVoListByHql(clazz, hql);
    }

    @Override
    public <E> List<E> findVoListByHql(Class clazz, String hql, Object... params) {
        return baseDaoI.findVoListByHql(clazz, hql, params);
    }

    @Override
    public <E> List<E> findVoListByHql(Class clazz, String hql, List<Object> params) {
        return baseDaoI.findVoListByHql(clazz, hql, params);
    }

    @Override
    public <E> List<E> findVoListByHql(Class clazz, String hql, Map<String, Object> params) {
        return baseDaoI.findVoListByHql(clazz, hql, params);
    }

    @Override
    public <E> Page<E> findVoPageByHql(Class clazz, Page<E> page, String hql) {
        return baseDaoI.findVoPageByHql(clazz, page, hql);
    }

    @Override
    public <E> Page<E> findVoPageByHql(Class clazz, Page<E> page, String hql, Object... params) {
        return baseDaoI.findVoPageByHql(clazz, page, hql, params);
    }

    @Override
    public <E> Page<E> findVoPageByHql(Class clazz, Page<E> page, String hql, List<Object> params) {
        return baseDaoI.findVoPageByHql(clazz, page, hql, params);
    }

    @Override
    public <E> Page<E> findVoPageByHql(Class clazz, Page<E> page, String hql, Map<String, Object> params) {
        return baseDaoI.findVoPageByHql(clazz, page, hql, params);
    }

    @Override
    public <E> List<E> findVoListBySql(Class clazz, String sql) {
        return baseDaoI.findVoListBySql(clazz, sql);
    }

    @Override
    public <E> List<E> findVoListBySql(Class clazz, String sql, Object... params) {
        return baseDaoI.findVoListBySql(clazz, sql, params);
    }

    @Override
    public <E> List<E> findVoListBySql(Class clazz, String sql, List<Object> params) {
        return baseDaoI.findVoListBySql(clazz, sql, params);
    }

    @Override
    public <E> List<E> findVoListBySql(Class clazz, String sql, Map<String, Object> params) {
        return baseDaoI.findVoListBySql(clazz, sql, params);
    }

    @Override
    public <E> Page<E> findVoPageBySql(Class clazz, Page<E> page, String sql) {
        return baseDaoI.findVoPageBySql(clazz, page, sql);
    }

    @Override
    public <E> Page<E> findVoPageBySql(Class clazz, Page<E> page, String sql, Object... params) {
        return baseDaoI.findVoPageBySql(clazz, page, sql, params);
    }

    @Override
    public <E> Page<E> findVoPageBySql(Class clazz, Page<E> page, String sql, List<Object> params) {
        return baseDaoI.findVoPageBySql(clazz, page, sql, params);
    }

    @Override
    public <E> Page<E> findVoPageBySql(Class clazz, Page<E> page, String sql, Map<String, Object> params) {
        return baseDaoI.findVoPageBySql(clazz, page, sql, params);
    }

    @Override
    public Long count(String hql) {
        return baseDaoI.count(hql);
    }

    @Override
    public Long count(String hql, Object... params) {
        return baseDaoI.count(hql, params);
    }

    @Override
    public Long count(String hql, List<Object> params) {
        return baseDaoI.count(hql, params);
    }

    @Override
    public Long count(String hql, Map<String, Object> params) {
        return baseDaoI.count(hql, params);
    }

    @Override
    public Integer executeHql(String hql) {
        return baseDaoI.executeHql(hql);
    }

    @Override
    public Integer executeHql(String hql, Object... params) {
        return baseDaoI.executeHql(hql, params);
    }

    @Override
    public Integer executeHql(String hql, List<Object> params) {
        return baseDaoI.executeHql(hql, params);
    }

    @Override
    public Integer executeHql(String hql, Map<String, Object> params) {
        return baseDaoI.executeHql(hql, params);
    }

    @Override
    public Integer executeSql(String sql) {
        return baseDaoI.executeSql(sql);
    }

    @Override
    public Integer executeSql(String sql, Object... params) {
        return baseDaoI.executeSql(sql, params);
    }

    @Override
    public Integer executeSql(String sql, List<Object> params) {
        return baseDaoI.executeSql(sql, params);
    }

    @Override
    public Integer executeSql(String sql, Map<String, Object> params) {
        return baseDaoI.executeSql(sql, params);
    }
}
