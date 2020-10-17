package cn.hdj.concurrency.javaThinking.concurrency_21_2;

import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: ADaemon
 * @Package cn.hdj.concurrency.javaThinking.concurrency_21_2
 * @Description: 验证后台线程是否会执行捕捉异常中finally代码块
 * @date 2018/1/19 11:59
 */
public class ADaemon implements Runnable {


    @Override
    public void run() {
        System.out.println("ADaemon start");
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("ADaemon.Run with finally broke execute");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        //// TODO: 2018/1/19

        /**
         * 一旦Main()退出，JVM就会立即关闭所有的后台进程，
         * 而不会由任何你希望出现的确认形式
         */
        Thread thread = new Thread(new ADaemon());
        thread.setDaemon(true);
        thread.start();
        System.out.println("ADaemon.main start");


    }

}
