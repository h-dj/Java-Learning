package cn.hdj.concurrency.progammingArt.chapter2.section2_2_9;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread
 * @Package cn.hdj.concurrency.progammingArt.chapter2.section2_2_9
 * @Description: TODO
 * @date 2018/9/20 11:34
 */
public class MyThreadB extends Thread {

    private Service service;

    public MyThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        Service.methodB();
    }
}
