package cn.hdj.concurrency.progammingArt.chapter2.section2_3_6;

import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Run
 * @Package cn.hdj.concurrency.progammingArt.chapter2.section2_3_6
 * @Description: TODO
 * @date 2018/9/21 15:05
 */
public class Run {


    public static void main(String[] args) throws InterruptedException {
        AtomCountTest atomCountTest = new AtomCountTest();

        MyThread[] myThreads = new MyThread[5];

        for (int i = 0; i < myThreads.length; i++) {
            myThreads[i] = new MyThread(atomCountTest);
        }
        for (int i = 0; i < myThreads.length; i++) {
            myThreads[i].start();
        }

        TimeUnit.SECONDS.sleep(3);
        System.out.println(atomCountTest.atomicLong.get());

    }
}
