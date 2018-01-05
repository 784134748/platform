package com.iflytek.operation.common.base.enumstatus;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>《基本类型》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2018/1/5]
 * @see [相关类/方法]
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BasicType implements BaseEnum<Integer> {
    /**
     * 是
     */
    YES(1, "是"),
    /**
     * 否
     */
    NO(-1, "否");

    BasicType(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    private Integer value;

    private String name;

    @Override
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class BaseTypeConvert extends BaseEnumConverter<BasicType, Integer> {

    }
}
