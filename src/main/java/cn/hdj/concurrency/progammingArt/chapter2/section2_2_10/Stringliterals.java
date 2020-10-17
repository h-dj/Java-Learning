package cn.hdj.concurrency.progammingArt.chapter2.section2_2_10;


/**
 * @author h_dj
 * @version V1.0
 * @Title: Stringliterals
 * @Package cn.hdj.concurrency.progammingArt.chapter2.section2_2_10
 * @Description: 字符串 因为常量特性；不使用String对象作为同步锁
 * 探究：
 * 官方文档：https://docs.oracle.com/javase/specs/jls/se10/html/jls-3.html#jls-3.10.5
 * 章节： 3.10.5. String Literals
 * 1. 在同一个包同一个类里，同一个literal string会引用同一个String对象
 * 2. 在同一个包不同类里，同一个literal string 会引用同一个String对象
 * 3. 在不同包不同类里，同一个literal string 也是引用同一个String对象
 * 4. 在编译时，literal string的拼接表达式运算，会先去找常量池中是否有该对象，有则引用，没有则创建
 * 5. 在运行时，literal string 与String变量的拼接运算，会创建一个新的String对象
 * 6. 在literal string 与String变量的拼接运算中，调用String方法intern()；会以literal string来匹配存在的字符串对象，
 * 查看拼接后的字符串内容是否与匹配到的字符串对象内容相同，相同则引用该对象
 * @date 2018/9/20 15:52
 */
public class Stringliterals {

    public static void main(String[] args) {

        String hello = "Hello", lo = "lo";
        System.out.print((hello == "Hello") + " ");
        System.out.print((Other.hello == hello) + " ");
        System.out.print((cn.hdj.concurrency.progammingArt.chapter2.section2_2_10.other.Other.hello == hello) + " ");
        System.out.print((hello == ("Hel" + "lo")) + " ");
        System.out.print((hello == ("Hel" + lo)) + " ");
        System.out.println("loHel" == (lo + "Hel").intern());
    }
}

class Other {
    static String hello = "Hello";
}
