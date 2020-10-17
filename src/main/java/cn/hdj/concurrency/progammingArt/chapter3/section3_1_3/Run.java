package cn.hdj.concurrency.progammingArt.chapter3.section3_1_3;

import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Run
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_3
 * @Description: TODO
 * @date 2018/9/21 16:54
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        Object lock=new Object();
        MyThreadA myThreadA=new MyThreadA(lock);

        myThreadA.start();

        TimeUnit.SECONDS.sleep(3);
        MyThreadB myThreadB=new MyThreadB(lock);

        myThreadB.start();

    }
}
