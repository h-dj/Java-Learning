package cn.hdj.basic;

/**
 * @Description: 类初始化顺序问题
 * @Author huangjiajian
 * @Date 2021/6/12 下午2:29
 */
public class InitOrderProblem {

    public static void main(String[] args) {
        B b = new B();


        int value = 10;
        value = 11;
        value = 22;
        System.out.println(22);

        value = 11 -3; //8
        value = 8 * 2; //16

        value = 16+1;//17
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


class Test {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
    }
    static class A {
        protected int value;
        public A (int v) {
            setValue(v);
        }
        public void setValue(int value) {
            this.value= value;
        }
        public int getValue() {
            try {
                value ++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }
    static class B extends A {
        public B () {
            super(5);
            setValue(getValue()- 3);
        }
        @Override
        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}
