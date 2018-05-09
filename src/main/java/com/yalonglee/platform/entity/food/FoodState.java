package com.yalonglee.platform.entity.food;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.AttributeConverter;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2018/4/5]
 * @see [相关类/方法]
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FoodState {

    /**
     * 上架
     */
    UP(0,"上架"),

    /**
     * 下架
     */
    DOWN(1, "下架");

    FoodState(Integer value, String name) {
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

    public static class OrderStateConvert implements AttributeConverter<FoodState, Integer> {
        @Override
        public Integer convertToDatabaseColumn(FoodState attribute) {
            return attribute == null ? null : attribute.getValue();
        }

        @Override
        public FoodState convertToEntityAttribute(Integer dbData) {
            for (FoodState type : FoodState.values()) {
                if (dbData.equals(type.getValue())) {
                    return type;
                }
            }
            throw new RuntimeException("Unknown database value: " + dbData);
        }
    }
}
