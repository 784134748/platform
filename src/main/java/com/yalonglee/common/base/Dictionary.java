package com.yalonglee.common.base;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2018/3/13]
 * @see [相关类/方法]
 */
public class Dictionary {

    /**
     * 字典项名称（业务名称）
     */
    private String dictionaryName;
    /**
     * 字典项别称（业务代码）
     */
    private String dictionaryAlise;
    /**
     * 操作类型（前台展示）
     */
    private String optionType;
    /**
     * 存储类型（后台存储）
     */
    private String dataType;

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }

    public String getDictionaryAlise() {
        return dictionaryAlise;
    }

    public void setDictionaryAlise(String dictionaryAlise) {
        this.dictionaryAlise = dictionaryAlise;
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

}
