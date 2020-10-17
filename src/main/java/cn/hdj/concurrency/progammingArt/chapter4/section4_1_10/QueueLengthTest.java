package cn.hdj.concurrency.progammingArt.chapter4.section4_1_10;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class QueueLengthTest {

    //可重入锁
    private ReentrantLock lock = new ReentrantLock();

    //创建多个condition
    Condition condition = lock.newCondition();


    public void print() {

        try {
            lock.lock();
            System.out.println("进入方法" + Thread.currentThread().getName());
            condition.await();
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    public static void main(String[] args) throws InterruptedException {

        final QueueLengthTest queueLengthTest = new QueueLengthTest();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                queueLengthTest.print();
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        TimeUnit.SECONDS.sleep(10);
        System.out.println("有线程数等待： " + queueLengthTest.lock.getQueueLength());
    }
}
