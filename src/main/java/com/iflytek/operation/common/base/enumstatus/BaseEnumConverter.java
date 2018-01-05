package com.iflytek.operation.common.base.enumstatus;

import javax.persistence.AttributeConverter;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

/**
 * <p>《枚举转换类》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2018/1/5]
 * @see [相关类/方法]
 */
public abstract class BaseEnumConverter<X extends BaseEnum<Y>, Y> implements AttributeConverter<BaseEnum<Y>, Y> {
    private Class<X> xclazz;
    private Method valuesMethod;

    public BaseEnumConverter() {
        this.xclazz = (Class<X>) (((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments())[0];
        try {
            valuesMethod = xclazz.getMethod("values");
        } catch (Exception e) {
            throw new RuntimeException("can't get values method from " + xclazz);
        }
    }

    @Override
    public Y convertToDatabaseColumn(BaseEnum<Y> attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public X convertToEntityAttribute(Y dbData) {
        try {
            X[] values = (X[]) valuesMethod.invoke(null);
            for (X x : values) {
                if (x.getValue().equals(dbData)) {
                    return x;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("can't convertToEntityAttribute" + e.getMessage());
        }
        throw new RuntimeException("unknown dbData " + dbData);
    }
}
