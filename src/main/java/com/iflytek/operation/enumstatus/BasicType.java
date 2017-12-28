package com.iflytek.operation.enumstatus;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * <p>流程类型枚举
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2016, ylshi@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author ylshi
 * @version [V1.0, 2016年7月15日]
 * @see [相关类/方法]
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BasicType {
    /**
     * 是
     */
    YES("是", "1"),
    /**
     * 否
     */
    NO("否", "0");

    BasicType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
