package cn.hdj.jvm.classloading;

/**
 * @Description:　`<clinit>()`　初始化　顺序
 * @Author huangjiajian
 * @Date 2021/4/11 下午2:21
 */
public class CInitOrder2 {

    static class Parent {
        public static int A = 1;

        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        //先执行完父类的静态代码块
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
