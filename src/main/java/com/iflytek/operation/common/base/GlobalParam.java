package com.iflytek.operation.common.base;

/**
 * <p>《一句话功能简述》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2017, listener@iflytek.com All Rights Reserve</p>
 * <p>Company : 科大讯飞</p>
 *
 * @author listener
 * @version [V1.0, 2017/12/10]
 * @see [相关类/方法]
 */
public class GlobalParam {
    /**
     * 构造函数私有化
     */
    private GlobalParam() {
    }

    /**
     * 枚举类型存储位置
     */
    public static String ENUMPATH = "com.iflytek.operation.enumstatus.";
    /**
     * 用于在session中存放当前用户信息的key
     */
    public final static String SESSION_USER_KEY = "SESSION_USER_KEY";
}
