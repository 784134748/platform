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
public enum RestaurantState {

    /**
     * 关闭
     */
    CLOSE(0,"关闭"),

    /**
     * 开启
     */
    OPEN(1, "开启");

    RestaurantState(Integer value, String name) {
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

    public static class RestaurantStateConvert implements AttributeConverter<RestaurantState, Integer> {
        @Override
        public Integer convertToDatabaseColumn(RestaurantState attribute) {
            return attribute == null ? null : attribute.getValue();
        }

        @Override
        public RestaurantState convertToEntityAttribute(Integer dbData) {
            if(null == dbData){
                return null;
            }
            for (RestaurantState type : RestaurantState.values()) {
                if (dbData.equals(type.getValue())) {
                    return type;
                }
            }
            throw new RuntimeException("Unknown database value: " + dbData);
        }
    }
}
