package cn.hdj.jvm.classloading;


/**
 * 被动引用： 演示三
 * 常量在编译阶段存入调用类的常量池中，本质上没有直接引用到定义常量的类，因此不会触发定义的常量
 *
 * @author hdj
 */
public class NoInitializationWithConst {
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWROLD);
    }
}
