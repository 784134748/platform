package com.yalonglee.platform.entity.example.basic;

import javax.persistence.AttributeConverter;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2018/1/8]
 * @see [相关类/方法]
 */
public enum SexType {
    /**
     * 男
     */
    YES(1, "男"),
    /**
     * 女
     */
    NO(-1, "女");

    SexType(Integer value, String name) {
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

    public static class SexTypeConvert implements AttributeConverter<SexType, Integer> {
        @Override
        public Integer convertToDatabaseColumn(SexType attribute) {
            return attribute == null ? null : attribute.getValue();
        }

        @Override
        public SexType convertToEntityAttribute(Integer dbData) {
            for (SexType type : SexType.values()) {
                if (dbData.equals(type.getValue())) {
                    return type;
                }
            }
            throw new RuntimeException("Unknown database value: " + dbData);
        }
    }
}
