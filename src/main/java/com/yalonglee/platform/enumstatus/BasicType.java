package com.yalonglee.platform.enumstatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.AttributeConverter;

/**
 * <p>《基本类型》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2018/1/5]
 * @see [相关类/方法]
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BasicType {
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

    public static class BasicTypeConvert implements AttributeConverter<BasicType, Integer> {
        @Override
        public Integer convertToDatabaseColumn(BasicType attribute) {
            return attribute == null ? null : attribute.getValue();
        }

        @Override
        public BasicType convertToEntityAttribute(Integer dbData) {
            for (BasicType type : BasicType.values()) {
                if (dbData.equals(type.getValue())) {
                    return type;
                }
            }
            throw new RuntimeException("Unknown database value: " + dbData);
        }
    }
}
