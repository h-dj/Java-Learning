package cn.hdj.jvm.classloading;


/**
 * 被动引用： 演示二
 * 通过数值定义来引用类，不会触发此类的初始化
 *
 * @author hdj
 */
public class NoInitializationWithArrayRef {
    public static void main(String[] args) {
        SuperClass[] sca = new SuperClass[10];
    }
}
