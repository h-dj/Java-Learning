package cn.hdj.arrays;

import java.util.Arrays;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Arrays5_3
 * @Package cn.hdj.arrays
 * @Description: 约瑟夫环问题
 * @date 2018/3/11 15:03
 */
public class Arrays5_3 {


    public static void main(String[] args) {


        int[][] arr2 = {{1, 2, 3}, {1, 2, 3}};
        System.out.println(Arrays.deepToString(arr2));
        //// TODO: 2018/3/11
        final int N = 13, S = 3, M = 5;  //N个人，从第S个人开始， 从1数到M
        //创建一个数组存放13个人
        int[] arr = new int[N];
        for (int h = 1; h <= arr.length; h++) {
            arr[h - 1] = h;
        }

        int i = S - 1, j, k = N, g = 1; //循环的次数
        System.out.println("输出出圈的顺序为： ");
        do {
            i = i + (M - 1);
            while (i >= k) {
                i = i - k;
            }
            System.out.print("  " + arr[i]);
            for (j = i; j < k - 1; j++) {
                arr[j] = arr[j + 1];
            }
            k--;
            g++;
        } while (g <= N);

        System.out.println();
    }





}
