package cn.hdj.basic;

/**
 * @Description: 内部类相关总结
 * @Author huangjiajian
 * @Date 2021/6/8 10:19
 */
public class InnerClassProblem {

    private String outerName = "abc";

    private static String staticOuterName = "static abc";

    public InnerClassProblem() {
    }

    public InnerClassProblem(String outerName) {
        this.outerName = outerName;
    }

    private void print() {
        System.out.println("外部类方法print" + outerName);
    }

    private static void staticPrint() {
        System.out.println("外部类静态方法staticPrint" + staticOuterName);
    }



    /**
     * 成员内部类
     * 1、可以添加访问修饰符
     * 2、可以访问外部类属性
     */
    private class InnerClassA {
        private String name;

        public void printOuterName() {
            //可以访问外部类
            System.out.println("访问外部类属性" + outerName);
        }
    }

    /**
     * 静态成员内部类
     * 1、可以添加访问修饰符
     * 2、只可以访问外部类静态成员、静态方法
     */
    public static class InnerClassB {
        private String name;

        public void printOuterName() {
            //不可以访问 外部类非成员变量、非成员方法
            //System.out.println("访问外部类属性" + outerName);
        }
    }


    private interface InterFaceA {
        void print();
    }

    private class InnerClassC {
    }

    public InterFaceA methodInnerClass() {
        String name = "abc";  //effctively final java8 只有一次赋值的变量默认都final
        String noEffectivelyVar = "noEffectivelyVar";  //不是effctively final
        noEffectivelyVar = "second assign";
        /**
         * 局部内部类 （只能方法内部访问）
         * 1、可以继承类，实现接口
         * 2、不能设置访问修饰符
         * 3、不能设置static
         */
        class MethodInnerClass extends InnerClassC implements InterFaceA {
            private String methodInnerClassName = "methodInnerClassName";

            public MethodInnerClass() {
            }

            public MethodInnerClass(String a) {
            }

            @Override
            public void print() {
                System.out.println("本类属性：" + methodInnerClassName + "外部类属性：" + outerName);
                System.out.println(name);
                //System.out.println(noEffectivelyVar); noEffectivelyVar不是 final变量，不能访问
            }
        }

        return new MethodInnerClass();
    }


    public static class AnonymousClass {
        private String name;

        public AnonymousClass() {
        }

        public AnonymousClass(String name) {
            this.name = name;
        }

        public void print() {
            System.out.println(name);
        }
    }

    public interface AnonymousInterface {
        void print();
    }

    //匿名类 - 继承
    AnonymousClass anonymousClass = new AnonymousClass() {
        private String nameA = "abc";
        private static final String FLAGA = "A"; //静态常量可以声明
        //private static String b = "A"; //不能声明静态成员

        /**
         * 重写父类方法
         */
        @Override
        public void print() {
            System.out.println("匿名类 - 继承");
            System.out.println(outerName);
        }

        public String getName() {
            return nameA;
        }
    };

    //匿名类 - 实现接口
    AnonymousInterface anonymousInterface = new AnonymousInterface() {
        @Override
        public void print() {
            System.out.println("匿名类 - 实现接口");
        }
    };

    public static void main(String[] args) {
        //实例化成员内部类  内部类 对象名 = 外部类对象.new 内部类( );
        InnerClassProblem problem = new InnerClassProblem();
        InnerClassA innerClassA = problem.new InnerClassA();
        innerClassA.printOuterName();

        final String name = "abc";

        //方法内部类
        InterFaceA interFaceA = problem.methodInnerClass();
        interFaceA.print();






    }
}
