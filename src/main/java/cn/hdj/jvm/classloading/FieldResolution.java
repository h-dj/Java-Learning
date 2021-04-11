package cn.hdj.jvm.classloading;

/**
 * @Description: 字段解析，　字段引用不明确导致解析失败
 * @Author huangjiajian
 * @Date 2021/4/10 下午11:01
 */
public class FieldResolution {

    interface Interface0 {
        int A = 0;
    }

    interface Interface1 extends Interface0 {
        int A = 1;
    }


    interface Interface2 {
        int A = 0;
    }

    static class Parent implements Interface1 {
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2 {
        //注释字段A
        //这时因为父类Parent　和接口　Interface2都包含字段A，导致解析字段引用不明确，解析失败
        //public static int A = 4;
    }

    public static void main(String[] args) {
        //System.out.println(Sub.A);
    }
}
