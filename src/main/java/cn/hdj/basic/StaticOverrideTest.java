package cn.hdj.basic;

/**
 * @Description: static 方法可以被重写吗？
 * @Author huangjiajian
 * @Date 2021/4/11 下午10:30
 * <p>
 * https://docs.oracle.com/javase/tutorial/java/IandI/override.html
 * <p>
 * <p>
 * 静态方法是在编译阶段就静态绑定
 * 实例方法是在运行时动态绑定
 */
public class StaticOverrideTest {
    static class Person {

        public static String getName() {
            return "Person";
        }


    }

    static class Student extends Person {

        //这个不是重写父类静态方法，而是把父类静态方法隐藏
        public static String getName() {
            return "Student";
        }
        //不能重写父类静态方法
//        public String getName() {
//            return "Student";
//        }
    }


    public static void main(String[] args) {
        String name = Person.getName();
        System.out.println(name);
    }
}
