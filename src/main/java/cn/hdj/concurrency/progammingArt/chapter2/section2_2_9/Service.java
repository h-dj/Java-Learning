package cn.hdj.concurrency.progammingArt.chapter2.section2_2_9;

import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Service
 * @Package cn.hdj.concurrency.progammingArt.chapter2.section2_2_9
 * @Description: TODO
 * @date 2018/9/20 11:22
 */
public class Service {


    /**
     * 静态同步方法
     * 持有类锁
     *
     */
    public synchronized static void methodA() {
        try {
            System.out.println(Thread.currentThread().getName() + " enter methodA");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + " leave methodA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 静态同步代码块
     * 持有类锁
     *
     * @throws InterruptedException
     */
    public static void methodB()  {
        try {
            synchronized (Service.class) {
                System.out.println(Thread.currentThread().getName() + " enter methodB");
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " leave methodB");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 同步方法
     * 持有对象锁
     */
    public synchronized void methodC()  {

        try {
            System.out.println(Thread.currentThread().getName() + " enter methodC");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + " leave methodC");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 同步代码块
     * 持有对象锁
     */
    public void methodD() {
        try {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " enter methodD");
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " leave methodD");

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 同步代码块
     * 持有自定义对象锁 -- lock
     *
     */
    private Object lock = new Object();

    public void methodE(){
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " enter methodE");
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " leave methodE");

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
