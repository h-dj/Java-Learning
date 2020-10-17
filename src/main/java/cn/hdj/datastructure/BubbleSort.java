package cn.hdj.datastructure;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author h_dj
 * @version V1.0
 * @Title: BubbleSort
 * @Package cn.hdj.datastructure
 * @Description: 冒泡排序
 * @date 2018/3/27 23:10
 */
public class BubbleSort {

    private Sortor sortor;

       //排序器
    public interface Sortor {

        //排序实现了comparable接口的对象数据
        public <T extends Comparable<T>> void sort(T[] list);

        //通过传入的比较器Comparator对数组进行排序
        public <T> void sort(T[] list, Comparator<T> comparator);
    }

    public class BasicBubbleSortor implements Sortor {

        @Override
        public <T extends Comparable<T>> void sort(T[] list) {
            boolean swapped = true;
            for (int i = 1, len = list.length; i < len && swapped; ++i) {
                //System.out.println("i = "+i);
                swapped = false;
                for (int j = 0; j < len - i; ++j) {
                  //  System.out.println(list[j]+" "+list[j + 1]);
                    if (list[j].compareTo(list[j + 1]) > 0) {
                        T temp = list[j];
                        list[j] = list[j + 1];
                        list[j + 1] = temp;
                        swapped = true;
                    }
                }
            }
        }

        @Override
        public <T> void sort(T[] list, Comparator<T> comparator) {
            boolean swapped = true;
            for (int i = 1, len = list.length; i < len && swapped; ++i) {
                swapped = false;
                for (int j = 0; j < len - i; ++j) {
                    if (comparator.compare(list[j], list[j + 1]) > 0) {
                        T temp = list[j];
                        list[j] = list[j + 1];
                        list[j + 1] = temp;
                        swapped = true;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        //// TODO: 2018/3/27



        Integer[] a = new Integer[]{1, 2, 3, 8, 5, 1, 2};
        Sortor sortor = new BubbleSort().new BasicBubbleSortor();
        sortor.sort(a);
        System.out.println(Arrays.toString(a));

    }


}


class Student {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}