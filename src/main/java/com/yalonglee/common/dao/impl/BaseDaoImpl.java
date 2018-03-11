package com.yalonglee.common.dao.impl;

import com.yalonglee.common.base.Page;
import com.yalonglee.common.dao.BaseDaoI;
import com.yalonglee.common.util.ReflectionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
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
        Assert.notNull(id, "id is null");
        return (T) this.getCurrentSession().get(entityClass, id);
    }

    @Override
    public T load(Serializable id) {
        Assert.notNull(id, "id is null");
        return (T) this.getCurrentSession().load(entityClass, id);
    }

    @Override
    public <E> E getVoByHql(Class clazz, String hql) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(clazz, hql);
        List<E> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public <E> E getVoByHql(Class clazz, String hql, Object... params) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(clazz, hql, params);
        List<E> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public <E> E getVoByHql(Class clazz, String hql, List<Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(clazz, hql, params);
        List<E> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public <E> E getVoByHql(Class clazz, String hql, Map<String, Object> params) {
        Assert.hasText(hql, "hql is null");
        Query query = createQuery(clazz, hql, params);
        List<E> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public <E> E getVoBySql(Class clazz, String sql) {
        Assert.hasText(sql, "sql is null");
        Query query = createNativeQuery(clazz, sql);
        List<E> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public <E> E getVoBySql(Class clazz, String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        Query query = createNativeQuery(clazz, sql, params);
        List<E> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public <E> E getVoBySql(Class clazz, String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        Query query = createNativeQuery(clazz, sql, params);
        List<E> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public <E> E getVoBySql(Class clazz, String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        Query query = createNativeQuery(clazz, sql, params);
        List<E> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public T getEntityBySql(String sql) {
        Assert.hasText(sql, "hql is null");
        Query query = createNativeQuery(sql);
        List<T> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public T getEntityBySql(String sql, Object... params) {
        Assert.hasText(sql, "hql is null");
        Query query = createNativeQuery(sql, params);
        List<T> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public T getEntityBySql(String sql, List<Object> params) {
        Assert.hasText(sql, "hql is null");
        Query query = createNativeQuery(sql, params);
        List<T> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public T getEntityBySql(String sql, Map<String, Object> params) {
        Assert.hasText(sql, "hql is null");
        Query query = createNativeQuery(sql, params);
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
        return createNativeQuery(sql).list();
    }

    @Override
    public List<T> findListBySql(String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        return createNativeQuery(sql, params).list();
    }

    @Override
    public List<T> findListBySql(String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        return createNativeQuery(sql, params).list();
    }

    @Override
    public List<T> findListBySql(String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        return createNativeQuery(sql, params).list();
    }

    @Override
    public Page<T> findPageBySql(Page<T> page, String sql) {
        Assert.hasText(sql, "sql is null");
        page.setResult(createNativeQuery(page, sql).list());
        return page;
    }

    @Override
    public Page<T> findPageBySql(Page<T> page, String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        page.setResult(createNativeQuery(page, sql, params).list());
        return page;
    }

    @Override
    public Page<T> findPageBySql(Page<T> page, String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        page.setResult(createNativeQuery(page, sql, params).list());
        return page;
    }

    @Override
    public Page<T> findPageBySql(Page<T> page, String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        page.setResult(createNativeQuery(page, sql, params).list());
        return page;
    }

    @Override
    public <E> List<E> findVoListByHql(Class clazz, String hql) {
        Assert.hasText(hql, "hql is null");
        return createQuery(clazz, hql).list();
    }

    @Override
    public <E> List<E> findVoListByHql(Class clazz, String hql, Object... params) {
        Assert.hasText(hql, "hql is null");
        return createQuery(clazz, hql, params).list();
    }

    @Override
    public <E> List<E> findVoListByHql(Class clazz, String hql, List<Object> params) {
        Assert.hasText(hql, "hql is null");
        return createQuery(hql, params).list();
    }

    @Override
    public <E> List<E> findVoListByHql(Class clazz, String hql, Map<String, Object> params) {
        Assert.hasText(hql, "hql is null");
        return createQuery(clazz, hql, params).list();
    }

    @Override
    public <E> Page<E> findVoPageByHql(Class clazz, Page<E> page, String hql) {
        Assert.hasText(hql, "hql is null");
        page.setResult(createQuery(clazz, page, hql).list());
        return page;
    }

    @Override
    public <E> Page<E> findVoPageByHql(Class clazz, Page<E> page, String hql, Object... params) {
        Assert.hasText(hql, "hql is null");
        page.setResult(createQuery(clazz, page, hql, params).list());
        return page;
    }

    @Override
    public <E> Page<E> findVoPageByHql(Class clazz, Page<E> page, String hql, List<Object> params) {
        Assert.hasText(hql, "hql is null");
        page.setResult(createQuery(clazz, page, hql, params).list());
        return page;
    }

    @Override
    public <E> Page<E> findVoPageByHql(Class clazz, Page<E> page, String hql, Map<String, Object> params) {
        Assert.hasText(hql, "hql is null");
        page.setResult(createQuery(clazz, page, hql, params).list());
        return page;
    }

    @Override
    public <E> List<E> findVoListBySql(Class clazz, String sql) {
        Assert.hasText(sql, "sql is null");
        return createNativeQuery(clazz, sql).list();
    }

    @Override
    public <E> List<E> findVoListBySql(Class clazz, String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        return createNativeQuery(clazz, sql, params).list();
    }

    @Override
    public <E> List<E> findVoListBySql(Class clazz, String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        return createNativeQuery(clazz, sql, params).list();
    }

    @Override
    public <E> List<E> findVoListBySql(Class clazz, String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        return createNativeQuery(clazz, sql, params).list();
    }

    @Override
    public <E> Page<E> findVoPageBySql(Class clazz, Page<E> page, String sql) {
        Assert.hasText(sql, "sql is null");
        page.setResult(createNativeQuery(clazz, page, sql).list());
        return page;
    }

    @Override
    public <E> Page<E> findVoPageBySql(Class clazz, Page<E> page, String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        page.setResult(createNativeQuery(clazz, page, sql, params).list());
        return page;
    }

    @Override
    public <E> Page<E> findVoPageBySql(Class clazz, Page<E> page, String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        page.setResult(createNativeQuery(clazz, page, sql, params).list());
        return page;
    }

    @Override
    public <E> Page<E> findVoPageBySql(Class clazz, Page<E> page, String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        page.setResult(createNativeQuery(clazz, page, sql, params).list());
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
        NativeQuery query = createNativeQuery(sql);
        return query.executeUpdate();
    }

    @Override
    public Integer executeSql(String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        NativeQuery query = createNativeQuery(sql, params);
        return query.executeUpdate();
    }

    @Override
    public Integer executeSql(String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        NativeQuery query = createNativeQuery(sql, params);
        return query.executeUpdate();
    }

    @Override
    public Integer executeSql(String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        NativeQuery query = createNativeQuery(sql, params);
        return query.executeUpdate();
    }

    @Override
    public NativeQuery createNativeQuery(String sql) {
        Assert.hasText(sql, "sql is null");
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        return nativeQuery;
    }

    @Override
    public NativeQuery createNativeQuery(String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                nativeQuery.setParameter(i, params[i]);
            }
        }
        return nativeQuery;
    }

    @Override
    public NativeQuery createNativeQuery(String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                nativeQuery.setParameter(i, params.get(i));
            }
        }
        return nativeQuery;
    }

    @Override
    public NativeQuery createNativeQuery(String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        if (params == null || params.isEmpty()) {
            return nativeQuery;
        }
        for (String key : params.keySet()) {
            if (sql.contains(":" + key)) {
                if (params.get(key) instanceof Collection) {
                    nativeQuery.setParameterList(key, (Collection<?>) params.get(key));
                } else if (params.get(key) instanceof Object[]) {
                    nativeQuery.setParameterList(key, (Object[]) params.get(key));
                } else {
                    nativeQuery.setParameter(key, params.get(key));
                }
            }
        }
        return nativeQuery;
    }

    @Override
    public NativeQuery createNativeQuery(Class clazz, String sql) {
        Assert.hasText(sql, "sql is null");
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        nativeQuery.setResultTransformer(Transformers.aliasToBean(clazz));
        return nativeQuery;
    }

    @Override
    public NativeQuery createNativeQuery(Class clazz, String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        nativeQuery.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                nativeQuery.setParameter(i, params[i]);
            }
        }
        return nativeQuery;
    }

    @Override
    public NativeQuery createNativeQuery(Class clazz, String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        nativeQuery.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                nativeQuery.setParameter(i, params.get(i));
            }
        }
        return nativeQuery;
    }

    @Override
    public NativeQuery createNativeQuery(Class clazz, String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        nativeQuery.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params == null || params.isEmpty()) {
            return nativeQuery;
        }
        for (String key : params.keySet()) {
            if (sql.contains(":" + key)) {
                if (params.get(key) instanceof Collection) {
                    nativeQuery.setParameterList(key, (Collection<?>) params.get(key));
                } else if (params.get(key) instanceof Object[]) {
                    nativeQuery.setParameterList(key, (Object[]) params.get(key));
                } else {
                    nativeQuery.setParameter(key, params.get(key));
                }
            }
        }
        return nativeQuery;
    }

    @Override
    public NativeQuery createNativeQuery(Page<T> page, String sql) {
        Assert.hasText(sql, "sql is null");
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        nativeQuery.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        nativeQuery.setMaxResults(page.getPageSize());
        return nativeQuery;
    }

    @Override
    public NativeQuery createNativeQuery(Page<T> page, String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                nativeQuery.setParameter(i, params[i]);
            }
        }
        nativeQuery.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        nativeQuery.setMaxResults(page.getPageSize());
        return nativeQuery;
    }

    @Override
    public NativeQuery createNativeQuery(Page<T> page, String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                nativeQuery.setParameter(i, params.get(i));
            }
        }
        nativeQuery.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        nativeQuery.setMaxResults(page.getPageSize());
        return nativeQuery;
    }

    @Override
    public NativeQuery createNativeQuery(Page<T> page, String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        if (params == null || params.isEmpty()) {
            return nativeQuery;
        }
        for (String key : params.keySet()) {
            if (sql.contains(":" + key)) {
                if (params.get(key) instanceof Collection) {
                    nativeQuery.setParameterList(key, (Collection<?>) params.get(key));
                } else if (params.get(key) instanceof Object[]) {
                    nativeQuery.setParameterList(key, (Object[]) params.get(key));
                } else {
                    nativeQuery.setParameter(key, params.get(key));
                }
            }
        }
        nativeQuery.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        nativeQuery.setMaxResults(page.getPageSize());
        return nativeQuery;
    }

    @Override
    public NativeQuery createNativeQuery(Class clazz, Page<?> page, String sql) {
        Assert.hasText(sql, "sql is null");
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        nativeQuery.setResultTransformer(Transformers.aliasToBean(clazz));
        nativeQuery.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        nativeQuery.setMaxResults(page.getPageSize());
        return nativeQuery;
    }

    @Override
    public NativeQuery createNativeQuery(Class clazz, Page<?> page, String sql, Object... params) {
        Assert.hasText(sql, "sql is null");
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        nativeQuery.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                nativeQuery.setParameter(i, params[i]);
            }
        }
        nativeQuery.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        nativeQuery.setMaxResults(page.getPageSize());
        return nativeQuery;
    }

    @Override
    public NativeQuery createNativeQuery(Class clazz, Page<?> page, String sql, List<Object> params) {
        Assert.hasText(sql, "sql is null");
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        nativeQuery.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                nativeQuery.setParameter(i, params.get(i));
            }
        }
        nativeQuery.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        nativeQuery.setMaxResults(page.getPageSize());
        return nativeQuery;
    }

    @Override
    public NativeQuery createNativeQuery(Class clazz, Page<?> page, String sql, Map<String, Object> params) {
        Assert.hasText(sql, "sql is null");
        NativeQuery nativeQuery = this.getCurrentSession().createNativeQuery(sql);
        nativeQuery.setResultTransformer(Transformers.aliasToBean(clazz));
        if (params == null || params.isEmpty()) {
            return nativeQuery;
        }
        for (String key : params.keySet()) {
            if (sql.contains(":" + key)) {
                if (params.get(key) instanceof Collection) {
                    nativeQuery.setParameterList(key, (Collection<?>) params.get(key));
                } else if (params.get(key) instanceof Object[]) {
                    nativeQuery.setParameterList(key, (Object[]) params.get(key));
                } else {
                    nativeQuery.setParameter(key, params.get(key));
                }
            }
        }
        nativeQuery.setFirstResult((page.getCurrentPageNo() - 1) * page.getPageSize());
        nativeQuery.setMaxResults(page.getPageSize());
        return nativeQuery;
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
