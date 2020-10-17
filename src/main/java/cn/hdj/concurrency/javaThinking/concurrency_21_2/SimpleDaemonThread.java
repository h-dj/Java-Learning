package cn.hdj.concurrency.javaThinking.concurrency_21_2;

import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: SimpleDaemonThread
 * @Package cn.hdj.concurrency.javaThinking
 * @Description: 简单的守护线程
 * @date 2018/1/18 17:57
 */
public class SimpleDaemonThread implements Runnable {


    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("守护线程 " + this);
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return Thread.currentThread()+"";
    }

    public static void main(String[] args) throws InterruptedException {
        //// TODO: 2018/1/18
        Thread thread = new Thread(new SimpleDaemonThread());
        thread.setDaemon(true);//在调用start()前。设置该线程位守护线程
        thread.start();

        System.out.println("守护线程启动");
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}
