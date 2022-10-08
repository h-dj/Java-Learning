package cn.hdj.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author huangjiajian
 * @Date 2021/6/2 16:31
 * <p>
 * 集合遍历、集合迭代删除
 */
public class ListIteratorMethodTest {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        iteratorThree(arrayList);


        List<? extends B> as=new ArrayList<D>();
        List<? extends A> as5=new ArrayList<B>();

        as5 = as;
       // List<A> as3=new ArrayList<B>();
        List<?> as2=new ArrayList<Object>();

        List as4 =new ArrayList<A>();


        /**
         * 迭代删除
         */
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }


    }

    class A {}
    class B extends A {}
    class C extends A {}
    class D extends B {}

    /**
     * 普通循环遍历
     *
     * @param arrayList
     */
    private static void iteratorOne(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("当前arrayList是" + arrayList.toString());
        }
    }

    /**
     * foreach 遍历
     * 底层采用Iterator
     *
     * @param arrayList
     */
    private static void iteratorTwo(ArrayList<Integer> arrayList) {
        for (Integer integer : arrayList) {
            System.out.println("当前arrayList是" + arrayList.toString());
        }
    }


    /**
     * 采用迭代器
     *
     * @param arrayList
     */
    public static void iteratorThree(ArrayList<Integer> arrayList) {
        Iterator<Integer> iterator = arrayList.iterator();

        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println(value);
        }
    }

    /**
     * 使用java8 forEach
     *
     * @param arrayList
     */
    public static void iteratorFour(ArrayList<Integer> arrayList) {
        arrayList.forEach(System.out::println);
    }
}
