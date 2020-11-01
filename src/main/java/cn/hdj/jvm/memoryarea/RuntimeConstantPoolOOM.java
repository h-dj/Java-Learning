package cn.hdj.jvm.memoryarea;

import java.util.HashSet;
import java.util.Set;

/**
 * 方法区和运行时常量池  OOM
 * 在JDK 6或更早之前的HotSpot虚拟机中，常量池都是分配在永久代中，
 * 使用-XX:PermSize 或 -XX:MaxPermSize参数限制永久的的大小，当超出-XX:MaxPermSize限制的大小时会抛出OOM
 * <p>
 * <p>
 * <p>
 * 自JDK7起，原本存放在永久代的字符串常量池被移至Java堆之中，
 * 所以在JDK 7及以上版本，限制方法区的容量对该测试用例来说是毫无意义的，只有限制堆的大小才会出现OOM
 * <p>
 * JVM  arg:
 * Java7 : -XX:PermSize=6m  -XX:MaxPermSize=6m
 * Java8 : -XX:MaxMetaspaceSize=6m
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //测试OOM
        Set<String> strings = new HashSet<>();
        Short i = 0;
        while (true) {
            strings.add(String.valueOf(i++).intern());
        }
    }
}
