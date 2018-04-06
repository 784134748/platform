package com.yalonglee.common.annotation;

import java.lang.annotation.*;

/**
 * <p>《自定义数据字典注解》
 * <p><功能详细描述>
 * <p>
 * <p>Copyright (c) 2018, listener@yalonglee.com All Rights Reserve</p>
 * <p>Company : yalonglee</p>
 *
 * @author listener
 * @version [V1.0, 2018/3/10]
 * @see [相关类/方法]
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Dict {
    /**
     * 数据字典code
     * @return
     */
    String value() default "";
}
