package cn.hdj.annotations.SQLGenenator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 修饰javaBean域的注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Containts {
    /**
     * 是否是主键
     * @return
     */
    boolean primaryKey() default false;

    /**
     * 是否可以为空
     * @return
     */
    boolean allowNull() default true;

    /**
     * 是否独一
     * @return
     */
    boolean unique() default false;
}
