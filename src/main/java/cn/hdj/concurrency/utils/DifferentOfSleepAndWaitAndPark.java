package cn.hdj.concurrency.utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author huangjiajian
 * @Date 2021/6/17 12:17
 */
public class DifferentOfSleepAndWaitAndPark {

    public static void main(String[] args) throws InterruptedException {
//        test_sleep();
//        test_sleep_lock_lose();

//        test_wait();
//        test_wait_timeout();

        test_park();
    }



    public static void test_sleep() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "执行完成！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程A").start();
        System.out.println("执行比线程A快");
    }

    /**
     * 测试Thread.sleep 是否会释放锁: 不会
     */
    public static void test_sleep_lock_lose() {

        final Object lock = new Object();

        new Thread(() -> {
            try {
                synchronized (lock){
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "执行完成！");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程A").start();

        new Thread(() -> {
            try {
                synchronized (lock){
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "执行完成！");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程B").start();
    }

    /**
     * 测试 Object.wait()的使用，及是否释放锁： 会释放锁
     */
    public static void test_wait(){
        final Object lock = new Object();

        Thread threadA = new Thread(() -> {
            try {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "开始执行");
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName() + "执行完成！");
                    //唤醒线程B
                    lock.notify();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程A");

        Thread threadB = new Thread(() -> {
            try {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "挂起！");
                    //释放锁，线程开始获取锁
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + "执行完成！");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程B");


        threadB.start();
        threadA.start();
    }

    /**
     * wait 超时释放锁
     */
    public static void test_wait_timeout(){
        final Object lock = new Object();

        Thread threadA = new Thread(() -> {
            try {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "开始执行");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "执行完成！");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程A");

        Thread threadB = new Thread(() -> {
            try {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "挂起！超时5秒");
                    //5秒后，重新获取锁，继续执行
                    lock.wait(5000);
                    System.out.println(Thread.currentThread().getName() + "执行完成！");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程B");


        threadB.start();
        threadA.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程A当前状态"+threadA.getState().name());
        System.out.println("线程B当前状态"+threadB.getState().name());
    }

    /**
     * 测试LockSupport.park 挂起线程
     */
    public static void test_park(){
        Thread threadA = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "挂起！");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "执行完成！");
        }, "线程A");

        threadA.start();
        try {
            System.out.println("主线程睡眠5秒");
            TimeUnit.SECONDS.sleep(5);
            //唤醒线程A
            LockSupport.unpark(threadA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
