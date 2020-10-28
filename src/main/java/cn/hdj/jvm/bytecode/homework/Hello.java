package cn.hdj.jvm.bytecode.homework;

/**
 * 自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后
 * 自己分析一下对应的字节码，有问题群里讨论。
 */
public class Hello {

    public static void hello() {
        int sum = 0;
        for (int i = 0; i <= 5; i++) {
            if (i % 2 == 0) {
                sum++;
            }
        }
    }
}
