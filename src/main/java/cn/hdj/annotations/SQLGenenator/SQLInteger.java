package cn.hdj.annotations.SQLGenenator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {

    String name() default "";
    /**
     * 嵌套注解；
     * @return
     */
    Containts containts() default @Containts;
}
