package cn.hdj.concurrency.progammingArt.chapter3.section3_1_5;

import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Run
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_5
 * @Description: TODO
 * @date 2018/9/26 10:44
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        Object lock=new Object();

        MyThread myThreadA=new MyThread(lock);
        MyThread myThreadB=new MyThread(lock);
        MyThread myThreadC=new MyThread(lock);


        myThreadA.start();
        myThreadB.start();
        myThreadC.start();
        NotifyThread notifyThread=new NotifyThread(lock);
        TimeUnit.SECONDS.sleep(1);

        notifyThread.start();


    }
}
