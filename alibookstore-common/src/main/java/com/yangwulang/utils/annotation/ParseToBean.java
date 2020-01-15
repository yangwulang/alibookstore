package com.yangwulang.utils.annotation;


import java.lang.annotation.*;

/**
 * @author yangwulang
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ParseToBean {
    Class<?> clazz = null;

    String value() default "";
}
