package cn.hdj.concurrency.javaThinking.concurrency_21_2;

import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: LiftOff
 * @Package cn.hdj.concurrency.javaThinking
 * @Description: TODO
 * @date 2018/1/18 16:17
 */
public class LiftOff implements Runnable {

    private int countDown = 10; //倒计时间
    private static int taskCount = 0; //任务倒计 计数

    //id用来区分多个任务的实例
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    /**
     * 倒计状态
     *
     * @return
     */
    public String status() {
        return " #" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ")";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());

            /**
             * cn.hdj.concurrency.yield();线程的调度器
             */
           // Thread.yield();
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}