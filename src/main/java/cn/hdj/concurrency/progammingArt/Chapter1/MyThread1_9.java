package cn.hdj.concurrency.progammingArt.Chapter1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread1_9
 * @Package cn.hdj.concurrency.progammingArt.Chapter1
 * @Description: TODO
 * @date 2018/9/11 11:36
 */
public class MyThread1_9 extends Thread {

    @Override
    public void run() {
        super.run();
        long a = System.currentTimeMillis();
        long count = 0;
        for (long i = 0; i < 100000; i++) {
           // Thread.yield();
            count = count + i;
        }
        long b = System.currentTimeMillis();
        System.out.println("所用时间：" + (b - a) / 100.0);
    }


    public static void main(String[] args) {
        MyThread1_9 myThread1_9=new MyThread1_9();
        myThread1_9.start();


    }
}
