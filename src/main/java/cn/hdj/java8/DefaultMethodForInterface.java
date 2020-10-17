package cn.hdj.java8;

/**
 * @author h_dj
 * @version V1.0
 * @Title: DefaultMethodForInterface
 * @Package cn.hdj.java8
 * @Description: 接口拥有默认方法
 * 接口中的默认方法，可以直接使用
 * @date 2018/3/29 23:37
 */
public class DefaultMethodForInterface {


    public interface Formula {
        //计算
        public double calc(int num);

        //默认方法
        default double sqrt(int num) {
            return Math.sqrt(num * 100);
        }

        //静态默认方法
        static void test() {
            System.out.println("123");
        }
    }


    /**
     * 讨论一个类实现多个接口，每个接口都有相同的默认方法
     * 1. 解决方法
     * 重写接口的方法
     * <p>
     * 2. 重写后使用 接口Xxx.super 来调用指定接口的默认方法：
     * Xxx.super.defaultMethod
     */

    public interface A {

        default void test() {
            System.out.println("interface A test method");
        }
    }

    public interface B {

        default void test() {
            System.out.println("interface B test method");
        }
    }

    class Clazz implements A, B {



        //重写默认方法
        @Override
        public void test() {
            //1. 都不调用接口的默认方法

            //2 .或者只调用接口A的默认方法
            //A.super.test();

            //3. 或者根据都调用
            A.super.test();
            B.super.test();
        }
    }

    public static void main(String[] args) {
        //// TODO: 2018/3/29

//        Formula formula = new Formula() {
//            @Override
//            public double calc(int num) {
//                Formula.test();
//                return sqrt(num);
//            }
//        };
//
//        formula.calc(45);


    }
}



