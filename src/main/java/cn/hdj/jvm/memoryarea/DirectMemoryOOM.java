package cn.hdj.jvm.memoryarea;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 直接内存OOM
 *
 * VM args : -Xmx20m -XX:MaxDirectMemorySize=10
 *
 * 注意：
 * 程序中又直接或间接使用了DirectMemory（典型的间接使用就是NIO），那就可以考虑重点检查一下直接内存方面的原因了。
 */
public class DirectMemoryOOM {


    private final static int _1M = 1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field declaredField = Unsafe.class.getDeclaredFields()[0];
        declaredField.setAccessible(true);
        Unsafe unsafe = (Unsafe) declaredField.get(null);
        while (true) {
            unsafe.allocateMemory(_1M);
        }
    }
}
