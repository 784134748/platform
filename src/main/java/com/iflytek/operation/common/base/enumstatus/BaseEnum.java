package com.iflytek.operation.common.base.enumstatus;

/**
 * <p>《枚举基类》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2018/1/5]
 * @see [相关类/方法]
 */
public interface BaseEnum<Y> {
    /**
     * 存取到数据库中的值.
     * @return
     */
    public Y getValue();
}
