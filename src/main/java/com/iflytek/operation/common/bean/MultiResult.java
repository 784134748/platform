package com.iflytek.operation.common.bean;

import java.util.List;
import java.util.Map;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/11]
 * @see [相关类/方法]
 */
public class MultiResult<T> extends BaseResult {

    /**
     * 列表数据封装
     */
    private List<T> rows;

    /**
     * 结果集的数量
     */
    private Integer total;

    /**
     * 特殊处理的
     */
    private Map<Object, Object> data;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Map<Object, Object> getData() {
        return data;
    }

    public void setData(Map<Object, Object> data) {
        this.data = data;
    }
}




