package com.iflytek.operation.common.dao.impl;

import com.iflytek.operation.common.base.Page;
import com.iflytek.operation.common.dao.BaseDaoI;
import com.iflytek.operation.common.util.ReflectionUtil;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>《通用DAO实现抽象类 实现所有通用的处理类》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/10]
 * @see [相关类/方法]
 */
public abstract class BaseDaoImpl<T> implements BaseDaoI<T> {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 泛型类的class
     */
    protected Class<T> entityClass;

    /**
     * <默认构造函数>
     */
    public BaseDaoImpl() {
        this.entityClass = ReflectionUtil.getSuperClassGenricType(getClass());
    }

    @Override
    public Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Serializable save(T o) {
        return getCurrentSession().save(o);
    }

    @Override
    public void delete(T o) {
        getCurrentSession().delete(o);
    }

    @Override
    public void update(T o) {
        getCurrentSession().update(o);
    }

    @Override
    public void saveOrUpdate(T o) {
        getCurrentSession().saveOrUpdate(o);
    }

    @Override
    public T get(Serializable id) {
        return (T) this.getCurrentSession().get(entityClass, id);
    }

    @Override
    public T load(Serializable id) {
        return (T) this.getCurrentSession().load(entityClass, id);
    }

    @Override
    public <E> E getDtoByHql(Class clazz, String hql) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(clazz, hql);
        List<E> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public <E> E getDtoByHql(Class clazz, String hql, Object... params) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(clazz, hql, params);
        List<E> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public <E> E getDtoByHql(Class clazz, String hql, List<Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(clazz, hql, params);
        List<E> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public <E> E getDtoByHql(Class clazz, String hql, Map<String, Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(clazz, hql, params);
        List<E> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public <E> E getDtoBySql(Class clazz, String sql) {
        Assert.hasText(sql, "sql is null");
        Query query = createSqlQuery(clazz, sql);
        List<E> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public <E> E getDtoBySql(Class clazz, String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        Query query = createSqlQuery(clazz, sql, params);
        List<E> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public <E> E getDtoBySql(Class clazz, String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        Query query = createSqlQuery(clazz, sql, params);
        List<E> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public <E> E getDtoBySql(Class clazz, String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        Query query = createSqlQuery(clazz, sql, params);
        List<E> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public T getEntityBySql(String sql) {
        Assert.hasText(sql, "hql is null");
        Query query = createSqlQuery(sql);
        List<T> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public T getEntityBySql(String sql, Object... params) {
        Assert.hasText(sql, "hql is null");
        Query query = createSqlQuery(sql, params);
        List<T> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public T getEntityBySql(String sql, List<Object> params) {
        Assert.hasText(sql, "hql is null");
        Query query = createSqlQuery(sql, params);
        List<T> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public T getEntityBySql(String sql, Map<String, Object> params) {
        Assert.hasText(sql, "hql is null");
        Query query = createSqlQuery(sql, params);
        List<T> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public T getEntityByHql(String hql) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(hql);
        List<T> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public T getEntityByHql(String hql, Object... params) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(hql, params);
        List<T> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public T getEntityByHql(String hql, List<Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(hql, params);
        List<T> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public T getEntityByHql(String hql, Map<String, Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(hql, params);
        List<T> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public <E> List<E> getParamsByHql(String hql) {
        Assert.hasText(hql, "hql is null");
        return createQuery(hql).list();
    }

    @Override
    public <E> List<E> getParamsByHql(String hql, Object... params) {
        Assert.hasText(hql, "hql is null");
        return createQuery(hql, params).list();
    }

    @Override
    public <E> List<E> getParamsByHql(String hql, List<Object> params) {
        Assert.hasText(hql, "hql is null");
        return createQuery(hql, params).list();
    }

    @Override
    public <E> List<E> getParamsByHql(String hql, Map<String, Object> params) {
        Assert.hasText(hql, "hql is null");
        return createQuery(hql, params).list();
    }

    @Override
    public <E> List<E> getParamsBySql(String sql) {
        return null;
    }

    @Override
    public <E> List<E> getParamsBySql(String sql, Object... params) {
        return null;
    }

    @Override
    public <E> List<E> getParamsBySql(String sql, List<Object> params) {
        return null;
    }

    @Override
    public <E> List<E> getParamsBySql(String sql, Map<String, Object> params) {
        return null;
    }

    @Override
    public List<T> findListByHql(String hql) {
        Assert.hasText(hql, "hql is null");
        return createQuery(hql).list();
    }

    @Override
    public List<T> findListByHql(String hql, Object... params) {
        Assert.hasText(hql, "hql is null");
        return createQuery(hql, params).list();
    }

    @Override
    public List<T> findListByHql(String hql, List<Object> params) {
        Assert.hasText(hql, "hql is null");
        return createQuery(hql, params).list();
    }

    @Override
    public List<T> findListByHql(String hql, Map<String, Object> params) {
        Assert.hasText(hql, "hql is null");
        return createQuery(hql, params).list();
    }

    @Override
    public Page<T> findPageByHql(Page<T> page, String hql) {
        Assert.hasText(hql, "hql is null");
        page.setResult(createQuery(page, hql).list());
        return page;
    }

    @Override
    public Page<T> findPageByHql(Page<T> page, String hql, Object... params) {
        Assert.hasText(hql, "hql is null");
        page.setResult(createQuery(page, hql, params).list());
        return page;
    }

    @Override
    public Page<T> findPageByHql(Page<T> page, String hql, List<Object> params) {
        Assert.hasText(hql, "hql is null");
        page.setResult(createQuery(page, hql, params).list());
        return page;
    }

    @Override
    public Page<T> findPageByHql(Page<T> page, String hql, Map<String, Object> params) {
        Assert.hasText(hql, "hql is null");
        page.setResult(createQuery(page, hql, params).list());
        return page;
    }

    @Override
    public List<T> findListBySql(String sql) {
        Assert.hasText(sql, "sql is null");
        return createSqlQuery(sql).list();
    }

    @Override
    public List<T> findListBySql(String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        return createSqlQuery(sql, params).list();
    }

    @Override
    public List<T> findListBySql(String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        return createSqlQuery(sql, params).list();
    }

    @Override
    public List<T> findListBySql(String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        return createSqlQuery(sql, params).list();
    }

    @Override
    public Page<T> findPageBySql(Page<T> page, String sql) {
        Assert.hasText(sql, "sql is null");
        page.setResult(createSqlQuery(page, sql).list());
        return page;
    }

    @Override
    public Page<T> findPageBySql(Page<T> page, String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        page.setResult(createSqlQuery(page, sql, params).list());
        return page;
    }

    @Override
    public Page<T> findPageBySql(Page<T> page, String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        page.setResult(createSqlQuery(page, sql, params).list());
        return page;
    }

    @Override
    public Page<T> findPageBySql(Page<T> page, String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        page.setResult(createSqlQuery(page, sql, params).list());
        return page;
    }

    @Override
    public <E> List<E> findDtoListByHql(Class clazz, String hql) {
        Assert.hasText(hql, "hql is null");
        return createQuery(clazz, hql).list();
    }

    @Override
    public <E> List<E> findDtoListByHql(Class clazz, String hql, Object... params) {
        Assert.hasText(hql, "hql is null");
        return createQuery(clazz, hql, params).list();
    }

    @Override
    public <E> List<E> findDtoListByHql(Class clazz, String hql, List<Object> params) {
        Assert.hasText(hql, "hql is null");
        return createQuery(hql, params).list();
    }

    @Override
    public <E> List<E> findDtoListByHql(Class clazz, String hql, Map<String, Object> params) {
        Assert.hasText(hql, "hql is null");
        return createQuery(clazz, hql, params).list();
    }

    @Override
    public <E> Page<E> findDtoPageByHql(Class clazz, Page<E> page, String hql) {
        Assert.hasText(hql, "hql is null");
        page.setResult(createQuery(clazz, page, hql).list());
        return page;
    }

    @Override
    public <E> Page<E> findDtoPageByHql(Class clazz, Page<E> page, String hql, Object... params) {
        Assert.hasText(hql, "hql is null");
        page.setResult(createQuery(clazz, page, hql, params).list());
        return page;
    }

    @Override
    public <E> Page<E> findDtoPageByHql(Class clazz, Page<E> page, String hql, List<Object> params) {
        Assert.hasText(hql, "hql is null");
        page.setResult(createQuery(clazz, page, hql, params).list());
        return page;
    }

    @Override
    public <E> Page<E> findDtoPageByHql(Class clazz, Page<E> page, String hql, Map<String, Object> params) {
        Assert.hasText(hql, "hql is null");
        page.setResult(createQuery(clazz, page, hql, params).list());
        return page;
    }

    @Override
    public <E> List<E> findDtoListBySql(Class clazz, String sql) {
        Assert.hasText(sql, "sql is null");
        return createSqlQuery(clazz, sql).list();
    }

    @Override
    public <E> List<E> findDtoListBySql(Class clazz, String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        return createSqlQuery(clazz, sql, params).list();
    }

    @Override
    public <E> List<E> findDtoListBySql(Class clazz, String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        return createSqlQuery(clazz, sql, params).list();
    }

    @Override
    public <E> List<E> findDtoListBySql(Class clazz, String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        return createSqlQuery(clazz, sql, params).list();
    }

    @Override
    public <E> Page<E> findDtoPageBySql(Class clazz, Page<E> page, String sql) {
        Assert.hasText(sql, "sql is null");
        page.setResult(createSqlQuery(clazz, page, sql).list());
        return page;
    }

    @Override
    public <E> Page<E> findDtoPageBySql(Class clazz, Page<E> page, String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        page.setResult(createSqlQuery(clazz, page, sql, params).list());
        return page;
    }

    @Override
    public <E> Page<E> findDtoPageBySql(Class clazz, Page<E> page, String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        page.setResult(createSqlQuery(clazz, page, sql, params).list());
        return page;
    }

    @Override
    public <E> Page<E> findDtoPageBySql(Class clazz, Page<E> page, String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        page.setResult(createSqlQuery(clazz, page, sql, params).list());
        return page;
    }

    @Override
    public Long count(String hql) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(hql);
        return (Long) query.uniqueResult();
    }

    @Override
    public Long count(String hql, Object... params) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(hql, params);
        return (Long) query.uniqueResult();
    }

    @Override
    public Long count(String hql, List<Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(hql, params);
        return (Long) query.uniqueResult();
    }

    @Override
    public Long count(String hql, Map<String, Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(hql, params);
        return (Long) query.uniqueResult();
    }

    @Override
    public Integer executeHql(String hql) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(hql);
        return query.executeUpdate();
    }

    @Override
    public Integer executeHql(String hql, Object... params) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(hql, params);
        return query.executeUpdate();
    }

    @Override
    public Integer executeHql(String hql, List<Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(hql, params);
        return query.executeUpdate();
    }

    @Override
    public Integer executeHql(String hql, Map<String, Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(hql, params);
        return query.executeUpdate();
    }

    @Override
    public Integer executeSql(String sql) {
        Assert.hasText(sql, "sql is null");
        SQLQuery query = createSqlQuery(sql);
        return query.executeUpdate();
    }

    @Override
    public Integer executeSql(String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        SQLQuery query = createSqlQuery(sql, params);
        return query.executeUpdate();
    }

    @Override
    public Integer executeSql(String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        SQLQuery query = createSqlQuery(sql, params);
        return query.executeUpdate();
    }

    @Override
    public Integer executeSql(String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        SQLQuery query = createSqlQuery(sql, params);
        return query.executeUpdate();
    }

    @Override
    public SQLQuery createSqlQuery(String sql) {
        Assert.hasText(sql, "sql is null");
        SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
        return sqlQuery;
    }

    @Override
    public SQLQuery createSqlQuery(String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                sqlQuery.setParameter(i, params[i]);
            }
        }
        return sqlQuery;
    }

    @Override
    public SQLQuery createSqlQuery(String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                sqlQuery.setParameter(i, params.get(i));
            }
        }
        return sqlQuery;
    }

    @Override
    public SQLQuery createSqlQuery(String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
        if (params == null || params.isEmpty()) {
            return sqlQuery;
        }
        for (String key : params.keySet()) {
            if (sql.contains(":" + key)) {
                if (params.get(key) instanceof Collection) {
                    sqlQuery.setParameterList(key, (Collection<?>) params.get(key));
                } else if (params.get(key) instanceof Object[]) {
                    sqlQuery.setParameterList(key, (Object[]) params.get(key));
                } else {
                    sqlQuery.setParameter(key, params.get(key));
                }
            }
        }
        return sqlQuery;
    }

    @Override
    public SQLQuery createSqlQuery(Class clazz, String sql) {
        Assert.hasText(sql, "sql is null");
        SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
        sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz));
        return sqlQuery;
    }

    @Override
    public SQLQuery createSqlQuery(Class clazz, String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
        sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                sqlQuery.setParameter(i, params[i]);
            }
        }
        return sqlQuery;
    }

    @Override
    public SQLQuery createSqlQuery(Class clazz, String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
        sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                sqlQuery.setParameter(i, params.get(i));
            }
        }
        return sqlQuery;
    }

    @Override
    public SQLQuery createSqlQuery(Class clazz, String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
        sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params == null || params.isEmpty()) {
            return sqlQuery;
        }
        for (String key : params.keySet()) {
            if (sql.contains(":" + key)) {
                if (params.get(key) instanceof Collection) {
                    sqlQuery.setParameterList(key, (Collection<?>) params.get(key));
                } else if (params.get(key) instanceof Object[]) {
                    sqlQuery.setParameterList(key, (Object[]) params.get(key));
                } else {
                    sqlQuery.setParameter(key, params.get(key));
                }
            }
        }
        return sqlQuery;
    }

    @Override
    public SQLQuery createSqlQuery(Page<T> page, String sql) {
        Assert.hasText(sql, "sql is null");
        SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
        sqlQuery.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        sqlQuery.setMaxResults(page.getPageSize());
        return sqlQuery;
    }

    @Override
    public SQLQuery createSqlQuery(Page<T> page, String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                sqlQuery.setParameter(i, params[i]);
            }
        }
        sqlQuery.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        sqlQuery.setMaxResults(page.getPageSize());
        return sqlQuery;
    }

    @Override
    public SQLQuery createSqlQuery(Page<T> page, String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                sqlQuery.setParameter(i, params.get(i));
            }
        }
        sqlQuery.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        sqlQuery.setMaxResults(page.getPageSize());
        return sqlQuery;
    }

    @Override
    public SQLQuery createSqlQuery(Page<T> page, String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
        if (params == null || params.isEmpty()) {
            return sqlQuery;
        }
        for (String key : params.keySet()) {
            if (sql.contains(":" + key)) {
                if (params.get(key) instanceof Collection) {
                    sqlQuery.setParameterList(key, (Collection<?>) params.get(key));
                } else if (params.get(key) instanceof Object[]) {
                    sqlQuery.setParameterList(key, (Object[]) params.get(key));
                } else {
                    sqlQuery.setParameter(key, params.get(key));
                }
            }
        }
        sqlQuery.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        sqlQuery.setMaxResults(page.getPageSize());
        return sqlQuery;
    }

    @Override
    public SQLQuery createSqlQuery(Class clazz, Page<?> page, String sql) {
        Assert.hasText(sql, "sql is null");
        SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
        sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz));
        sqlQuery.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        sqlQuery.setMaxResults(page.getPageSize());
        return sqlQuery;
    }

    @Override
    public SQLQuery createSqlQuery(Class clazz, Page<?> page, String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
        sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                sqlQuery.setParameter(i, params[i]);
            }
        }
        sqlQuery.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        sqlQuery.setMaxResults(page.getPageSize());
        return sqlQuery;
    }

    @Override
    public SQLQuery createSqlQuery(Class clazz, Page<?> page, String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
        sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                sqlQuery.setParameter(i, params.get(i));
            }
        }
        sqlQuery.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        sqlQuery.setMaxResults(page.getPageSize());
        return sqlQuery;
    }

    @Override
    public SQLQuery createSqlQuery(Class clazz, Page<?> page, String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        SQLQuery sqlQuery = this.getCurrentSession().createSQLQuery(sql);
        sqlQuery.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params == null || params.isEmpty()) {
            return sqlQuery;
        }
        for (String key : params.keySet()) {
            if (sql.contains(":" + key)) {
                if (params.get(key) instanceof Collection) {
                    sqlQuery.setParameterList(key, (Collection<?>) params.get(key));
                } else if (params.get(key) instanceof Object[]) {
                    sqlQuery.setParameterList(key, (Object[]) params.get(key));
                } else {
                    sqlQuery.setParameter(key, params.get(key));
                }
            }
        }
        sqlQuery.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        sqlQuery.setMaxResults(page.getPageSize());
        return sqlQuery;
    }

    @Override
    public Query createQuery(String hql) {
        Assert.hasText(hql, "hql is null");
        Query query = this.getCurrentSession().createQuery(hql);
        return query;
    }

    @Override
    public Query createQuery(String hql, Object... params) {
        Assert.hasText(hql, "hql is null");
        Query query = this.getCurrentSession().createQuery(hql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return query;
    }

    @Override
    public Query createQuery(String hql, List<Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = this.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i, params.get(i));
            }
        }
        return query;
    }

    @Override
    public Query createQuery(String hql, Map<String, Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = this.getCurrentSession().createQuery(hql);
        if (params == null || params.isEmpty()) {
            return query;
        }
        for (String key : params.keySet()) {
            if (hql.contains(":" + key)) {
                if (params.get(key) instanceof Collection) {
                    query.setParameterList(key, (Collection<?>) params.get(key));
                } else if (params.get(key) instanceof Object[]) {
                    query.setParameterList(key, (Object[]) params.get(key));
                } else {
                    query.setParameter(key, params.get(key));
                }
            }
        }
        return query;
    }

    @Override
    public Query createQuery(Class clazz, String hql) {
        Assert.hasText(hql, "hql is null");
        Query query = this.getCurrentSession().createQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(clazz));
        return query;
    }

    @Override
    public Query createQuery(Class clazz, String hql, Object... params) {
        Assert.hasText(hql, "hql is null");
        Query query = this.getCurrentSession().createQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return query;
    }

    @Override
    public Query createQuery(Class clazz, String hql, List<Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = this.getCurrentSession().createQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i, params.get(i));
            }
        }
        return query;
    }

    @Override
    public Query createQuery(Class clazz, String hql, Map<String, Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = this.getCurrentSession().createQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params == null || params.isEmpty()) {
            return query;
        }
        for (String key : params.keySet()) {
            if (hql.contains(":" + key)) {
                if (params.get(key) instanceof Collection) {
                    query.setParameterList(key, (Collection<?>) params.get(key));
                } else if (params.get(key) instanceof Object[]) {
                    query.setParameterList(key, (Object[]) params.get(key));
                } else {
                    query.setParameter(key, params.get(key));
                }
            }
        }
        return query;
    }

    @Override
    public Query createQuery(Page<T> page, String hql) {
        Assert.hasText(hql, "hql is null");
        Query query = this.getCurrentSession().createQuery(hql);
        query.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        query.setMaxResults(page.getPageSize());
        return query;
    }

    @Override
    public Query createQuery(Page<T> page, String hql, Object... params) {
        Assert.hasText(hql, "hql is null");
        Query query = this.getCurrentSession().createQuery(hql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        query.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        query.setMaxResults(page.getPageSize());
        return query;
    }

    @Override
    public Query createQuery(Page<T> page, String hql, List<Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = this.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i, params.get(i));
            }
        }
        query.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        query.setMaxResults(page.getPageSize());
        return query;
    }

    @Override
    public Query createQuery(Page<T> page, String hql, Map<String, Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = this.getCurrentSession().createQuery(hql);
        if (params == null || params.isEmpty()) {
            return query;
        }
        for (String key : params.keySet()) {
            if (hql.contains(":" + key)) {
                if (params.get(key) instanceof Collection) {
                    query.setParameterList(key, (Collection<?>) params.get(key));
                } else if (params.get(key) instanceof Object[]) {
                    query.setParameterList(key, (Object[]) params.get(key));
                } else {
                    query.setParameter(key, params.get(key));
                }
            }
        }
        query.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        query.setMaxResults(page.getPageSize());
        return query;
    }

    @Override
    public Query createQuery(Class clazz, Page<?> page, String hql) {
        Assert.hasText(hql, "hql is null");
        Query query = this.getCurrentSession().createQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(clazz));
        query.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        query.setMaxResults(page.getPageSize());
        return query;
    }

    @Override
    public Query createQuery(Class clazz, Page<?> page, String hql, Object... params) {
        Assert.hasText(hql, "hql is null");
        Query query = this.getCurrentSession().createQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        query.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        query.setMaxResults(page.getPageSize());
        return query;
    }

    @Override
    public Query createQuery(Class clazz, Page<?> page, String hql, List<Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = this.getCurrentSession().createQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                query.setParameter(i, params.get(i));
            }
        }
        query.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        query.setMaxResults(page.getPageSize());
        return query;
    }

    @Override
    public Query createQuery(Class clazz, Page<?> page, String hql, Map<String, Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = this.getCurrentSession().createQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params == null || params.isEmpty()) {
            return query;
        }
        for (String key : params.keySet()) {
            if (hql.contains(":" + key)) {
                if (params.get(key) instanceof Collection) {
                    query.setParameterList(key, (Collection<?>) params.get(key));
                } else if (params.get(key) instanceof Object[]) {
                    query.setParameterList(key, (Object[]) params.get(key));
                } else {
                    query.setParameter(key, params.get(key));
                }
            }
        }
        query.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        query.setMaxResults(page.getPageSize());
        return query;
    }

}
