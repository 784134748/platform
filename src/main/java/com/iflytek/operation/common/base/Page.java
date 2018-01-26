package com.iflytek.operation.common.base;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * <p>《分页》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/11]
 * @see [相关类/方法]
 */
public class Page<T> implements Serializable {
    
    private static final long serialVersionUID = 6629860755132341034L;
    
    /**
     * 默认页大小
     */
    public static int DEFAULT_PAGE_SIZE = 10;
    /**
     * 当前页码
     */
    protected int currentPageNo;
    /**
     * 页大小
     */
    protected int pageSize;
    /**
     * 结果集
     */
    protected List<T> result;
    /**
     * 查询结果总量
     */
    protected long totalCount;
    protected boolean autoCount;
    protected String formName;
    protected String orderBy;
    protected String order;
    private long start;

    public Page() {
        this(DEFAULT_PAGE_SIZE);
    }

    public Page(int pageSize) {
        this.currentPageNo = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.result = Collections.emptyList();
        this.totalCount = -1L;
        this.autoCount = true;
        this.setPageSize(pageSize);
    }

    public Page(int pageSize, boolean autoCount) {
        this.currentPageNo = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.result = Collections.emptyList();
        this.totalCount = -1L;
        this.autoCount = true;
        this.setPageSize(pageSize);
        this.setAutoCount(autoCount);
    }

    public Page(long start, long totalSize, int pageSize, List<T> data) {
        this.currentPageNo = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.result = Collections.emptyList();
        this.totalCount = -1L;
        this.autoCount = true;
        this.pageSize = pageSize;
        this.start = start;
        this.totalCount = totalSize;
        this.result = data;
    }

    public long getTotalPageCount() {
        Assert.isTrue(this.pageSize > 0,"pageSize not more than zero");
        return this.totalCount % (long) this.pageSize == 0L ? this.totalCount / (long) this.pageSize : this.totalCount / (long) this.pageSize + 1L;
    }

    public boolean isOrderBySetted() {
        return StringUtils.isNotBlank(this.orderBy) && StringUtils.isNotBlank(this.order);
    }

    public int getFirstOfPage() {
        return (this.currentPageNo - 1) * this.pageSize + 1;
    }

    public int getLastOfPage() {
        return this.currentPageNo * this.pageSize;
    }

    public int getCurrentPageNo() {
        return this.currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getResult() {
        return this.result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isAutoCount() {
        return this.autoCount;
    }

    public void setAutoCount(boolean autoCount) {
        this.autoCount = autoCount;
    }

    public long getStart() {
        return this.start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public String getOrderBy() {
        return this.orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public static String getAsc() {
        return "asc";
    }

    public static String getDesc() {
        return "desc";
    }

    public String getFormName() {
        return this.formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

}
