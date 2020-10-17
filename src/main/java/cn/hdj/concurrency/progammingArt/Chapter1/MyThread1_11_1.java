package cn.hdj.concurrency.progammingArt.Chapter1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread1_11_1
 * @Package cn.hdj.concurrency.progammingArt.Chapter1
 * @Description: 守护线程
 * @date 2018/9/11 14:53
 */
public class MyThread1_11_1 extends Thread {

    @Override
    public void run() {
        super.run();
        int i = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" I'am is the daemon thread " + (i++));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread1_11_1 myThread1_11_1=new MyThread1_11_1();
        // 开启守护线程
        myThread1_11_1.setDaemon(true);

        myThread1_11_1.start();
        Thread.sleep(5000);

        System.out.println("the main thread exit , so the myThread1_11_1 daemon thread will be exit");
    }
}
