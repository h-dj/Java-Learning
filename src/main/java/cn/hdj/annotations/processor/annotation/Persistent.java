package cn.hdj.annotations.processor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Persistent
 * @Package cn.hdj.annotations.processor.annotation
 * @Description: 修饰类的注解
 * @date 2017/11/13 19:39
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Persistent {
    String table();       //数据库中表名
}
