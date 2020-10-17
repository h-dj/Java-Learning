package cn.hdj.java8;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author h_dj
 * @version V1.0
 * @Title: StreamAPI
 * @Package cn.hdj.java8
 * @Description: 集合Stream的api
 * 1. Stream（流）是一个来自数据源的元素队列并支持聚合操作
 * 2. 生成流
 * - 从一个Collection通过stream()和 parallelStream()方法;
 * - 从阵列通过Arrays.stream(Object[]);
 * -  从流类的静态工厂方法，例如 Stream.of(Object[])， IntStream.range(int, int) 或Stream.iterate(Object, UnaryOperator);
 * - 文件的行元素流可以从BufferedReader类中的lines()方法获取;
 * - 文件路径流可以通过以下方法获得  Files类中：
 * - 随机数字流可以从Random.ints();
 * - 在JDK许多其他流的轴承的方法，包括 BitSet.stream()， Pattern.splitAsStream(java.lang.CharSequence)，和JarFile.stream()。
 * <p>
 * 3. 流的种类有：串行流和并行流
 * <p>
 * 4. 流操作： 中间操作（零或多个中间操作）和 终端操作 （一个）
 * - forEach()
 * -
 * @date 2018/3/31 14:19
 */
public class StreamAPI {

    @Test
    public void getStream() throws URISyntaxException, IOException {

        //从一个Collection通过stream()和 parallelStream()方法获取流;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        list.stream()
                .filter(integer -> integer % 2 == 0)
                .forEach(System.out::println);
        System.out.println();
        list.parallelStream()
                .filter(integer -> integer % 2 != 0)
                .forEach(System.out::println);

        System.out.println();

        //通过Arrays.stream(Object[])获取流
        Arrays.stream(new int[]{1, 2, 3, 4})
                .limit(3)
                .forEach(System.out::print);
        System.out.println();

    }


    @Test
    public void testForEach() throws FileNotFoundException {
//        Random random = new Random();
//        random.ints()
//                .limit(10)
//                .forEach(System.out::println);


        Spliterators.spliterator(new int[]{1, 2, 3}, 0)
                .forEachRemaining((int value) -> {
                    System.out.println(value);
                });

    }


    @Test
    public void testFilter() {
        //筛选100以内的偶数
        IntStream.range(1, 100)
                .filter(value -> value % 2 == 0)
                .forEach(System.out::println);
    }

    @Test
    public void testMap() {
        Stream.of(new Integer[]{1, 1, 2, 4, 5, 3, 8, 8, 8, 8})
                .map(integer -> {
                    integer = integer + 2;
                    return integer;
                })
                .forEach(integer -> {
                    System.out.print(integer + " ");
                });
    }


    @Test
    public void testDistinct() {
        Stream.of(new Integer[]{1, 1, 2, 4, 5, 3, 8, 8, 8, 8})
                .distinct()
                .forEach(System.out::println);
        //输出结果： 1  2  4 5  3  8

    }


    @Test
    public void testFlatMap() {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Arrays.asList("apple", "click"));
        lists.add(Arrays.asList("boss", "dig", "qq", "vivo"));
        lists.add(Arrays.asList("c#", "biezhi"));


        lists.stream()
                .flatMap(Collection::stream)
                .filter(str -> str.length() > 2)
                .forEach(strings -> {
                    System.out.print(strings + " ");
                });
    }

    @Test
    public void testCollect() {
        Person p1 = new Person(12, "a", true);
        Person p2 = new Person(20, "b", true);
        Person p3 = new Person(24, "c", false);
        Person p4 = new Person(20, "d", true);
        Person p5 = new Person(19, "e", false);

        List<Person> peoples = Arrays.asList(p1, p2, p3, p4, p5);

        //筛选男生，返回List集合
        List<Person> collect = peoples.stream()
                .filter(person -> person.isMale)
                .collect(Collectors.toList());


        //获取各个年龄端的人数
        Map<Integer, Long> collect1 = peoples.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
        System.out.println(collect1);

    }


    class Person {
        int age;
        String name;
        boolean isMale;

        public Person(int age, String name, boolean isMale) {
            this.age = age;
            this.name = name;
            this.isMale = isMale;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isMale() {
            return isMale;
        }

        public void setMale(boolean male) {
            isMale = male;
        }
    }
}
