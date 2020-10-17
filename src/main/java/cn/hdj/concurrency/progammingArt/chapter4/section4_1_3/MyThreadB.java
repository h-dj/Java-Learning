package cn.hdj.concurrency.progammingArt.chapter4.section4_1_3;

import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThreadA
 * @Package cn.hdj.concurrency.progammingArt.chapter4.section4_1_3
 * @Description: TODO
 * @date 2018/9/28 10:30
 */
public class MyThreadB extends Thread {


    private Service service;

    public MyThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.await();
    }


    public static void main(String[] args) throws InterruptedException {

        Service service = new Service();
        MyThreadB b = new MyThreadB(service);
        b.start();

        TimeUnit.SECONDS.sleep(2);
        service.signal();
    }

}
