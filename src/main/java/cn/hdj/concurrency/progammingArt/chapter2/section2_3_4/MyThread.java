package cn.hdj.concurrency.progammingArt.chapter2.section2_3_4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread
 * @Package cn.hdj.concurrency.progammingArt.chapter2.section2_3_4
 * @Description: TODO
 * @date 2018/9/21 11:44
 */
public class MyThread extends Thread {

    public volatile static int count;


    public static void addCount() {
        for (int i = 0; i < 100; i++) {

            count++;
        }
        System.out.println("count=" + count);
    }

    @Override
    public void run() {
        super.run();
        addCount();
    }

    public static void main(String[] args) {
        List<MyThread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new MyThread());
        }
        for (int i = 0; i < 10; i++) {
            threads.get(i).start();
        }
    }
}
