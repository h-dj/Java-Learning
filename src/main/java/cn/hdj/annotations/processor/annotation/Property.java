package cn.hdj.annotations.processor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Property
 * @Package cn.hdj.annotations.processor.annotation
 * @Description: TODO
 * @date 2017/11/13 19:38
 */
//属性注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Property {
    String column();    //该属性对应表中的列名

    String type();      //id属性类型
}
