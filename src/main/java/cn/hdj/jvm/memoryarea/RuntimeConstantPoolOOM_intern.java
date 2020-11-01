package cn.hdj.jvm.memoryarea;

/**
 * 方法区和运行时常量池  OOM 延申知识点
 *
 *  先了解intern 方法：
 * •  在JDK 6中，intern()方法会把首次遇到的字符串实例复制到永久代的字符串常量池中存储，返回这个字符串实例在永久代存储的引用
 * • 而在 JDK 7中，intern()方法实现就不需要再拷贝字符串的实例到永久代了，既然字符串常量池已经移到Java堆中，那只需要在常量池里记录一下首次出现的实例引用
 * • 还有所有的字符串字面量和字符串值常量表达式都会调用intern，存入字符串常量池中
 *
 */
public class RuntimeConstantPoolOOM_intern {

    public static void main(String[] args) {
        // jdk8u265 中 sun.misc.Version#launcher_name  不是java 而是openjdk

        //测试常量池:
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);  //true
        String str2 = new StringBuilder("open").append("jdk").toString();
        System.out.println(str2.intern() == str2);  //false

    }
}
