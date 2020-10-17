package cn.hdj.concurrency.progammingArt.Chapter1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread1_10_1_1
 * @Package cn.hdj.concurrency.progammingArt.Chapter1
 * @Description: 优先级--继承特性
 * @date 2018/9/11 14:05
 */
public class MyThread1_10_1_2 extends Thread {

    @Override
    public void run() {
        super.run();

        System.out.println("this thread priority" + this.getPriority());
        //
        MyThread1_10_1_1 myThread1_10_1_1 = new MyThread1_10_1_1();
        //myThread1_10_1_1.setPriority(1);
        myThread1_10_1_1.start();
    }

    public static void main(String[] args) {
        MyThread1_10_1_2 myThread1_10_1_2 = new MyThread1_10_1_2();
       myThread1_10_1_2.setPriority(10);
        myThread1_10_1_2.start();
    }

}
