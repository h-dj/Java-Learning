package cn.hdj.collection;

import java.util.*;

/**
 * @author h_dj
 * @version V1.0
 * @Title: ListPerformanceTest
 * @Package cn.hdj.collection
 * @Description: ArrayList 、LinkList和Vector查找和插入性能分析
 * @date 2017/11/1 15:21
 */
public class ListPerformanceTest {


    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkList = new LinkedList<>();
        List<Integer> vector = new Vector<>();
        //首先分别给两者插入10000条数据
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
            linkList.add(i);
            vector.add(i);
        }

        //获得两者随机访问的时间;
        System.out.println("arrayList time:" + getTime(arrayList));
        System.out.println("linked time:" + getTime(linkList));
        System.out.println("vector time:" + getTime(vector));
        //获得两者插入数据的时间
        System.out.println("arrayList insert time:" + insertTime(arrayList));
        System.out.println("linked insert time:" + insertTime(linkList));
        System.out.println("vector insert time:" + insertTime(vector));

    }

    public static long getTime(List<Integer> list) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            int index = Collections.binarySearch(list, list.get(i));
            if (index != i) {
                System.out.println("ERROR!");
            }
        }
        return System.currentTimeMillis() - time;
    }

    //插入数据
    public static long insertTime(List<Integer> list) {
        /*
         * 插入的数据量和插入的位置是决定两者性能的主要方面，
         * 我们可以通过修改这两个数据，来测试两者的性能
         */
        long num = 10000; //表示要插入的数据量
        int index = 1; //表示从哪个位置插入
        long time = System.currentTimeMillis();
        for (int i = 1; i < num; i++) {
            list.add(index, i);
        }
        return System.currentTimeMillis() - time;

    }
}

