package cn.hdj.jvm.classloading;


/**
 * 被动引用： 演示一
 * 非主动使用类字段演示
 * @author hdj
 */
public class NoInitializationWithStaticField {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
