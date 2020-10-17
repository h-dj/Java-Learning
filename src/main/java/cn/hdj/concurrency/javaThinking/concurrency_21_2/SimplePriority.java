package cn.hdj.concurrency.javaThinking.concurrency_21_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author h_dj
 * @version V1.0
 * @Title: SimplePriority
 * @Package cn.hdj.concurrency.javaThinking
 * @Description: 线程优先级
 * @date 2018/1/18 17:26
 */
public class SimplePriority implements Runnable {

    private int countDown = 5;
    private volatile double d;

    private int priority;//优先级

    public SimplePriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + " : " + countDown;
    }

    @Override
    public void run() {
        //设置线程优先级
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 0; i < 1000000; i++) {
                d += (Math.PI * Math.E) / (double) i;
                if (d % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        //// TODO: 2018/1/18

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i <5; i++) {
            executorService.execute(new SimplePriority(Thread.MIN_PRIORITY));
        }
        executorService.execute(new SimplePriority(Thread.MAX_PRIORITY));
        executorService.shutdown();
    }
}
