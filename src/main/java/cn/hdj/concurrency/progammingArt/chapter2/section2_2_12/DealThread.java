package cn.hdj.concurrency.progammingArt.chapter2.section2_2_12;

import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: DealThread
 * @Package cn.hdj.concurrency.progammingArt.chapter2.section2_2_12
 * @Description: TODO
 * @date 2018/9/21 10:23
 */
public class DealThread implements Runnable {

    private String username;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    @Override
    public void run() {
        if ("a".equals(username)) {
            synchronized (lock1) {
                System.out.println("username= " + username);

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock2) {
                    System.out.println("execute lock1--->lock2 ");
                }
            }
        }

        if ("b".equals(username)) {
            synchronized (lock2) {
                System.out.println("username= " + username);

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock1) {
                    System.out.println("execute lock2--->lock1 ");
                }
            }
        }
    }

    public static void main(String[] args) {
        DealThread a = new DealThread();
        a.username = "a";




        new Thread(a).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a.username = "b";
        new Thread(a).start();
    }
}
