package cn.hdj.concurrency.progammingArt.chapter4.section4_1_9;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread
 * @Package cn.hdj.concurrency.progammingArt.chapter4.section4_1_9
 * @Description: TODO
 * @date 2018/9/28 11:43
 */
public class MyThread extends Thread {


    private Service service;

    public MyThread() {

    }

    public MyThread(Service service) {
        this.service = service;
    }


    @Override
    public void run() {
        super.run();
        System.out.println("运行"+Thread.currentThread().getName());

        service.print();
    }
}
