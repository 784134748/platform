package com.iflytek.operation.common.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 结果DTO
 * 
 * @author hyzha
 * @lastModified
 * @history
 */

public class ResultDto {
    
    /**
     * 结果标示
     */
    private boolean flag;
    
    /**
     * 结果详细
     */
    @JSONField(name = "msg")
    private String result;
    
    /**
     * 需要传回页面的数据
     */
    private Object data;
    
    public ResultDto() {

    }
    
    public ResultDto(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
    
    public ResultDto(boolean flag, String result) {
        this.flag = flag;
        this.result = result;
    }
    
    public ResultDto(boolean flag, String result, Object data) {
        this.flag = flag;
        this.result = result;
        this.data = data;
    }
    
    /**
     * @return 返回 flag
     */
    public boolean isFlag() {
        return flag;
    }
    
    /**
     * 对flag进行赋值
     * @param
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    public String getResult() {
        return result;
    }
    
    public void setResult(String result) {
        this.result = result;
    }
    
    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
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
