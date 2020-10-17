package cn.hdj.concurrency.javaThinking.concurrency_21_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: DaemonFromFactory
 * @Package cn.hdj.concurrency.javaThinking
 * @Description: 从守护线程工厂创建线程
 * @date 2018/1/19 11:32
 */
public class DaemonFromFactory implements Runnable {


    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("DaemonFromFactory.Run" + Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //// TODO: 2018/1/19
        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new DaemonFromFactory());
        }
        System.out.println("DaemonFromFactory.main  all thread start");

        executorService.shutdown();
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}
