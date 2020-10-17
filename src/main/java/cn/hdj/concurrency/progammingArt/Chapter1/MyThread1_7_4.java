package cn.hdj.concurrency.progammingArt.Chapter1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread1_7_4
 * @Package cn.hdj.concurrency.progammingArt.Chapter1
 * @Description: 睡眠中停止
 * @date 2018/9/10 10:35
 */
public class MyThread1_7_4 extends Thread {

    @Override
    public void run() {
        super.run();

        try {
            System.out.println("start thread");
            Thread.sleep(1000000);
            System.out.println("end thread");
        } catch (InterruptedException e) {
            System.out.println(" thread sleep be interrupt" + this.isInterrupted());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            MyThread1_7_4 myThread1_7_4 = new MyThread1_7_4();
            myThread1_7_4.start();
            Thread.sleep(1000);
            myThread1_7_4.interrupt();
        } catch (Exception e) {
            System.out.println("main catch");
            e.printStackTrace();
        }

        System.out.println("end");
    }
}
