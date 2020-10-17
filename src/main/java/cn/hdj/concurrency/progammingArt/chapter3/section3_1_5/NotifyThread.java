package cn.hdj.concurrency.progammingArt.chapter3.section3_1_5;

/**
 * @author h_dj
 * @version V1.0
 * @Title: NotifyThread
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_5
 * @Description: TODO
 * @date 2018/9/26 11:18
 */
public class NotifyThread extends Thread {


    private Object lock;

    public NotifyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        synchronized (lock){
            lock.notify();
        }
    }
}
