package cn.hdj.basic;

/**
 * @Description: 类初始化顺序问题
 * @Author huangjiajian
 * @Date 2021/6/12 下午2:29
 */
public class InitOrderProblem {

    public static void main(String[] args) {
        B b = new B();
    }

}

class B {
    public static B t1 = new B();
    public static B t2 = new B();

    {
        System.out.println("构造块");
    }

    static {
        System.out.println("静态块");
    }
}

