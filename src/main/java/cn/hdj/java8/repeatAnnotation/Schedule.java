package cn.hdj.java8.repeatAnnotation;


import java.lang.annotation.*;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Schedule
 * @Package cn.hdj.java8.repeatAnnotation
 * @Description: 声明可重复注解
 * @date 2018/4/1 11:20
 */
@Repeatable(Schedules.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Schedule {
    String dayOfMonth() default "first";

    String dayOfWeek() default "Mon";

    int hour() default 12;
}
