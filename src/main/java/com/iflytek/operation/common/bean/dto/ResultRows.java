package com.iflytek.operation.common.bean.dto;


import com.iflytek.operation.common.bean.BaseResult;

import java.util.List;

/**
 * 返回结果封装类
 * <p><一句话功能简述>
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, qiangyin@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author qiangyin
 * @version [V1.0, 2017年3月15日]
 * @see [相关类/方法]
 */
public class ResultRows extends BaseResult {
    /**
     * 结果标示
     */
    private boolean flag;

    /**
     * 结果详细
     */
    private String msg;

    private List<Object> rows;

    private int total;

    public ResultRows() {

    }

    public ResultRows(boolean flag, String msg, int total, List<Object> rows) {
        this.flag = flag;
        this.msg = msg;
        this.total = total;
        this.rows = rows;
    }

    @Override
    public String getMsg() {
        return msg;
    }


    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }


    public List<Object> getRows() {
        return rows;
    }

    public void setRows(List<Object> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * 返回 flag
     *
     * @return
     */
    @Override
    public boolean isFlag() {
        return flag;
    }

    /**
     * 对flag进行赋值
     *
     * @param
     */
    @Override
    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    public static ResultDto success(String result) {
        ResultDto dto = new ResultDto();
        dto.setFlag(true);
        dto.setResult(result);
        return dto;
    }

    public static ResultDto success(String result, Object data) {
        return new ResultDto(true, result, data);
    }

    public static ResultDto success(Object data) {
        return new ResultDto(true, data);
    }

    public static ResultDto fail(String result, Object data) {
        return new ResultDto(false, result, data);
    }

    public static ResultDto fail(String result) {
        ResultDto dto = new ResultDto();
        dto.setFlag(false);
        dto.setResult(result);
        return dto;
    }


}
