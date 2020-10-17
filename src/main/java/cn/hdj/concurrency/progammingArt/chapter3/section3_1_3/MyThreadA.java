package cn.hdj.concurrency.progammingArt.chapter3.section3_1_3;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_3
 * @Description: TODO
 * @date 2018/9/21 16:50
 */
public class MyThreadA extends Thread {

    private Object lock;
    private Object lock1 =new Object();

    public MyThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        synchronized (lock) {
            System.out.println("进入同步：开始wait  ");
            try {
                lock1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("结束同步：结束wait");
        }

    }
}
