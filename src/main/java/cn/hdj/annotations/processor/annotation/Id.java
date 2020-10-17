package cn.hdj.annotations.processor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Id
 * @Package cn.hdj.annotations.processor.annotation
 * @Description: TODO
 * @date 2017/11/13 19:37
 */
//修饰Id注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {
    String column();    //该id属性对应表中的列名

    String type();      //id属性类型

    String generator(); //使用的策略
}
