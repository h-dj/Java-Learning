package cn.hdj.concurrency.progammingArt.chapter2.section2_2_10;

import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Service
 * @Package cn.hdj.concurrency.progammingArt.chapter2.section2_2_10
 * @Description: TODO
 * @date 2018/9/20 13:30
 */
public class Service {

    public static void methodA(String string) {

        synchronized (string) {

            while (true) {
                System.out.println(Thread.currentThread().getName() + " enter methodA  args=" + string);
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public static void methodB(Object o) {

        try {
            synchronized (o) {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " enter methodA  args=" + o);
                    TimeUnit.SECONDS.sleep(5);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
