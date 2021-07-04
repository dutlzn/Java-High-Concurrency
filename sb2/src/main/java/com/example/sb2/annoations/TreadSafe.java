package com.example.sb2.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来标记线程安全的类
 */
@Target(ElementType.TYPE) // 作用对象
@Retention(RetentionPolicy.SOURCE) // 注解存在的范围
public @interface TreadSafe {
    String value() default "";
}
