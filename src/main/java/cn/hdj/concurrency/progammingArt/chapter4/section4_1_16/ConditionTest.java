package cn.hdj.concurrency.progammingArt.chapter4.section4_1_16;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    private final static ReentrantLock lock = new ReentrantLock();
    private final static Condition c1 = lock.newCondition();
    private final static Condition c2 = lock.newCondition();
    private final static Condition c3 = lock.newCondition();
    private volatile static int a = 1;

    public static void main(String[] args) {

        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (a != 1)
                        c1.await();

                    for (int i = 0; i < 3; i++) {
                        System.out.println("Thread t1  " + (i + 1));
                    }

                    a = 2;
                    c2.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };
        Runnable t2 = new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (a != 2)
                        c2.await();

                    for (int i = 0; i < 3; i++) {
                        System.out.println("Thread t2  " + (i + 1));
                    }

                    a = 3;
                    c3.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };
        Runnable t3 = new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (a != 3)
                        c3.await();

                    for (int i = 0; i < 3; i++) {
                        System.out.println("Thread t3  " + (i + 1));
                    }

                    a = 1;
                    c1.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(t1).start();
            new Thread(t2).start();
            new Thread(t3).start();

        }
    }
}
