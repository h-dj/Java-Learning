package cn.hdj.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 元注解（meta-annotation）
 *
 * @Target : 用来定义注解将用在什么地方（例如一个域或方法）
         TYPE,          类、接口或枚举声明
        FIELD,          域声明（包括枚举实例）
        METHOD,          方法声明
        PARAMETER,          参数声明
        CONSTRUCTOR,         构造器声明
        LOCAL_VARIABLE,        局部变量声明
        ANNOTATION_TYPE,         注解类型声明
        PACKAGE                 包声明
 * @Retention ： 用来定义注解在哪个级别可用；在源码中（SOURCE）、类文件中（CLASS）或运行时（RUNTIME）
 *
 * @Inherited : 允许子类继承父类中的注解、
 *
 *
 * 没有元素的注解称为标记注解（marker annotation）
 *
 *
 * 注解元素：
 *      所有基本类型（int ,float, boolean）
 *      String
 *      Class
 *      enum
 *      Annotation
 *      以上类型的数组
 *
 * 默认值限制
 *
 * 注解不支持继承
 *      扩展注解可以使用嵌套的方式
 *       @Target(ElementType.FIELD)
         @Retention(RetentionPolicy.RUNTIME)
         public @interface SQLString {
         int value() default 0;

         String name() default "";

         Containts containts() default @Containts;

         }
        使用：
         @SQLString(value = 30, containts = @Containts(primaryKey = true))
         String handle;


 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DefinitionAnnotition {
}
