package cn.hdj.concurrency.progammingArt.chapter3.section3_1_5;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_5
 * @Description: TODO
 * @date 2018/9/26 10:38
 */
public class MyThread extends Thread {


    private Object lock;

    public MyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        Service service = new Service();
        service.testMethod(lock);
    }
}
