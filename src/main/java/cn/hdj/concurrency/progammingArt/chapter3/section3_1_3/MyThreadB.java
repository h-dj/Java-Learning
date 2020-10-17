package cn.hdj.concurrency.progammingArt.chapter3.section3_1_3;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_3
 * @Description: TODO
 * @date 2018/9/21 16:50
 */
public class MyThreadB extends Thread {

    private Object lock;

    public MyThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        synchronized (lock) {
            System.out.println("进入同步：开始notify  ");
            lock.notify();
            System.out.println("结束同步：结束notify");
        }

    }
}
