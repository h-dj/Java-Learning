package cn.hdj.concurrency.progammingArt.chapter4.section4_1_6;

import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Run
 * @Package cn.hdj.concurrency.progammingArt.chapter4.section4_1_6
 * @Description: TODO
 * @date 2018/9/28 11:02
 */
public class Run {


    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        MyThreadA myThreadA = new MyThreadA(service);
        MyThreadB myThreadB = new MyThreadB(service);

        myThreadA.setName("A");
        myThreadB.setName("B");
        myThreadA.start();
        myThreadB.start();

        TimeUnit.SECONDS.sleep(3);

        service.signalAll_A();
    }
}
