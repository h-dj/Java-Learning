package cn.hdj.basic;

/**
 * @Description: 类初始化顺序问题
 * @Author huangjiajian
 * @Date 2021/6/12 下午2:29
 */
public class InitOrderProblem {

    public static void main(String[] args) {
        B b = new B();

        C c = new C.D();
    }

}

class B {
    public static B t1 = new B();
    public static B t2 = new B();

    {
        System.out.println("构造块");
    }

    static {
        //静态代码块只会初始化一次
        System.out.println("静态块");
    }
}


class C {
    private String name = "C";

    public C() {
        //callName 方法被重写了，但是此时调用子类的callName
        // 读取的是子类的name，但是子类的name 还没有初始化
        //所以打印为null
        callName();
    }

    public void callName() {
        System.out.println(name);
    }

    public static class D extends C {
        private String name = "D";

        @Override
        public void callName() {
            System.out.println(name);
        }
    }
}