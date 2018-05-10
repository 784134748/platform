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
public enum OrderState {
    /**
     * 待确认
     */
    WAIT(0, "待确认"),
    /**
     * 已付款
     */
    READY(1, "已确认"),
    /**
     * 派送中
     */
    ON_WAY(2, "派送中"),
    /**
     * 已签收
     */
    OK(3, "已签收"),
    /**
     * 退订
     */
    BACK(4, "退订"),
    /**
     * 下架
     */
    DOWN(5, "下架");


    OrderState(Integer value, String name) {
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

    public static class OrderStateConvert implements AttributeConverter<OrderState, Integer> {
        @Override
        public Integer convertToDatabaseColumn(OrderState attribute) {
            return attribute == null ? null : attribute.getValue();
        }

        @Override
        public OrderState convertToEntityAttribute(Integer dbData) {
            if(null == dbData){
                return null;
            }
            for (OrderState type : OrderState.values()) {
                if (dbData.equals(type.getValue())) {
                    return type;
                }
            }
            throw new RuntimeException("Unknown database value: " + dbData);
        }
    }
}
