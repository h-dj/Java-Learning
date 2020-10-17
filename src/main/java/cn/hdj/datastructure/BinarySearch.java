package cn.hdj.datastructure;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author h_dj
 * @version V1.0
 * @Title: BinarySearch
 * @Package cn.hdj.datastructure
 * @Description: 折半查找
 * @date 2018/3/28 11:03
 */
public class BinarySearch {


    public static <T extends Comparable<T>> int binarySearch(T[] list, T key) {
        return binarySearch(list, 0, list.length - 1, key);
    }


    //递归实现折半查找
    public static <T extends Comparable<T>> int binarySearch(T[] list, int low, int hight, T key) {
        if (low <= hight) {
            //中间值
            int mid = low + (hight - low) / 2;
            System.out.println(mid);
            if (key.compareTo(list[mid]) == 0) {
                return mid;
            } else if (key.compareTo(list[mid]) > 0) {
                return binarySearch(list, mid + 1, hight, key);
            } else {
                return binarySearch(list, low, mid - 1, key);
            }
        }
        return -1;
    }

    public static <T> int binarySearch(T[] list, T key, Comparator<T> comparator) {
        int low = 0;
        int hight = list.length - 1;
        while (low <= hight) {
            int mid = low + (hight - low) / 2;
            if (comparator.compare(key, list[mid]) == 0) {
                return mid;
            } else if (comparator.compare(key, list[mid]) > 0) {
                low = mid + 1;
            } else {
                hight = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        //// TODO: 2018/3/28

        Integer[] a = new Integer[]{1, 5, 8, 2, 4, 6};
        Arrays.sort(a);
        int i = binarySearch(a, 6);
        System.out.println(i);

        int i1 = binarySearch(a, 8, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(i1);
    }
}
