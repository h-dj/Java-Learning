package cn.hdj.concurrency.progammingArt.chapter3.section3_2;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_2
 * @Description: 线程join 的使用
 * @date 2018/9/27 9:29
 */
public class MyThread extends Thread {


    @Override
    public void run() {
        super.run();
        try {
            int sleepTime = (int) Math.random() * 10000+1000;

            System.out.println("sleepTime = " + sleepTime);
            sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

    }
}
