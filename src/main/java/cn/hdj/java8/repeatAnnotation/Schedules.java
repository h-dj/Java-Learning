package cn.hdj.java8.repeatAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Schedules
 * @Package cn.hdj.java8.repeatAnnotation
 * @Description: 声明含有注解的注解
 * @date 2018/4/1 11:25
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Schedules {
    Schedule[] value();
}
