package cn.hdj.jvm.classloading;

/**
 * 被动引用： 演示一
 * 通过子类引用父类的静态字段，不会导致子类的初始化
 * jvm arg: -XX:+TraceClassLoading
 */
public class SubClass extends SuperClass{

    static {
        System.out.println("SubClass init!");
    }
}
