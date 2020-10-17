package cn.hdj.java8;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author h_dj
 * @version V1.0
 * @Title: LambdaExpressions
 * @Package cn.hdj.java8
 * @Description: Lambda 表达式
 * 1. 语法：
 * - 形式参数列表
 * (a,b,c) ; 单个参数可以省略括号 如： a
 * <p>
 * - 箭头标记， ->
 * <p>
 * - 一个主体： 由单个表达式或语句块组成； 语句块用花括号包围{ }
 * <p>
 * 2. :: 操作符
 * - 引用成员方法
 * 如： Integer::new
 */
public class LambdaExpressions {

    /**
     * 根据年龄打印List中的Person
     * 这个方法只能匹配大于某个年龄段的person, 但匹配某个年龄范围的person，就要更改方法
     *
     * @param roster
     * @param age
     */
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    /**
     * 匹配某个年龄范围的person, 但是如果Person类的字段改变了或者要添加姓名的匹配条件，
     * 这样又要更改许多API； 怎样解决呢？
     * - 可以把匹配的条件抽取出来
     *
     * @param roster
     * @param low
     * @param hight
     */
    public static void printPersonsOlderThan(List<Person> roster, int low, int hight) {
        for (Person p : roster) {
            if (p.getAge() >= low && p.getAge() <= hight) {
                p.printPerson();
            }
        }
    }

    /**
     * 匹配Person的条件判断逻辑接口
     */

    public interface CheckPerson {
        boolean test(Person p);
    }

//    public static void printPersonsOlderThan(List<Person> roster, CheckPerson tester) {
//        for (Person p : roster) {
//            if (tester.test(p)) {
//                p.printPerson();
//            }
//        }
//    }

    /**
     * 使用带有Lambda表达式的内置标准接口
     *
     * @param roster
     * @param tester
     */
    public static void printPersonsOlderThan(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    /**
     * 使用带有Lambda表达式的内置标准接口
     * 匹配成功时，应有的操作抽象出来，使用标准接口Consumer 方法void accept(T t);
     *
     * @param roster
     * @param tester
     */
    public static void printPersonsOlderThan(List<Person> roster, Predicate<Person> tester, Consumer<Person> consumer) {
        for (Person p : roster) {
            if (tester.test(p)) {
                consumer.accept(p);
            }
        }
    }

    /**
     * 使用带有Lambda表达式的内置标准接口
     * 匹配成功时，应有的操作抽象出来，使用标准接口Consumer 方法void accept(T t);
     * 在操作相应的逻辑时，不执行Person printPerson方法，只打印Person名称， 则需要使用标准接口Function<T, R> 方法 R apply(T t);
     *
     * @param roster
     * @param tester
     * @param consumer
     * @param function
     */
//    public static void printPersonsOlderThan(
//            List<Person> roster,
//            Predicate<Person> tester,
//            Consumer<String> consumer,
//            Function<Person, String> function) {
//        for (Person p : roster) {
//            if (tester.test(p)) {
//                String s = function.apply(p);
//                consumer.accept(s);
//            }
//        }
//    }

    /**
     * 利用泛型
     *
     * @param roster
     * @param tester
     * @param consumer
     * @param function
     */
    public static <x, y> void printPersonsOlderThan(
            List<x> roster,
            Predicate<x> tester,
            Consumer<y> consumer,
            Function<x, y> function) {
        for (x p : roster) {
            if (tester.test(p)) {
                y s = function.apply(p);
                consumer.accept(s);
            }
        }
    }

    public static void main(String[] args) {
        //// TODO: 2018/3/31

        /**
         * 1. Lambda表达式的简单使用
         */
        //Java7 创建匿名接口
        /*Calc calc7 = new Calc() {
            @Override
            public void calc(int a, int b) {
                int c = a + b;
                System.out.println("没有使用Lambda " + c);
            }
        };

        calc7.calc(7, 7);

        //Java8 Lambda 创建匿名接口； 注意，接口只能有一个抽象的方法
        //形式参数列表中的参数可以不指定类型, (a, b); 如果只有单个参数，括号可以省略
        Calc calc8 = (int a, int b) -> {
            int c = a + b;
            System.out.println("使用Lambda " + c);
        };
        calc8.calc(8, 8);*/


        List<Person> peoples = Arrays.asList(new Person[]{
                new Person("a", 1),
                new Person("b", 2),
                new Person("c", 3),
                new Person("d", 4)});
        //2. 结合函数接口使用Lambda
        //使用匿名类
//        printPersonsOlderThan(peoples, new CheckPerson() {
//            @Override
//            public boolean test(Person p) {
//                return p.getAge() > 2 && p.getAge() < 4 || p.getName().equals("b");
//            }
//        });
        //匿名类转变为Lambda
        printPersonsOlderThan(
                peoples,
                p -> p.getAge() > 2 && p.getAge() < 4 || p.getName().equals("b")
        );

        printPersonsOlderThan(
                peoples,
                (Person p) -> p.getAge() > 2 && p.getAge() < 4 || p.getName().equals("b"),
                (Person p) -> {
                    System.out.println(p.getName());
                }
        );

        printPersonsOlderThan(
                peoples,
                (Person p) -> p.getAge() > 2 && p.getAge() < 4 || p.getName().equals("b"),
                (String str) -> System.out.println(str),
                (Person p) -> p.getName()
        );


    }

}

//@FunctionalInterface 注解可写，也可以省略；表明是一个函数接口，以至于能够使用Lambda表达式转换
interface Calc {
    void calc(int a, int b);

    default void defaultMethod() {
        System.out.println("defaultMethod");
    }
}

//筛选对象
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void printPerson() {
        System.out.println(this.toString());
    }
}
