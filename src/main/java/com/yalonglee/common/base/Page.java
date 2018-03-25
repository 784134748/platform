package com.yalonglee.common.base;

import java.io.Serializable;
import java.util.List;

/**
 * <p>《分页》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/11]
 * @see [相关类/方法]
 */
public class Page<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 默认页大小
     */
    public static int DEFAULT_PAGE_SIZE = 10;
    /**
     * 当前页码
     */
    private int currentPageNo = 1;
    /**
     * 页大小
     */
    private int pageSize;
    /**
     * 结果集
     */
    private List<T> result;
    /**
     * 查询结果总量
     */
    private long totalCount;

    public static int getDefaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public static void setDefaultPageSize(int defaultPageSize) {
        DEFAULT_PAGE_SIZE = defaultPageSize;
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}
