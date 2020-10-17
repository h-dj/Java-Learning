package cn.hdj.concurrency.progammingArt.chapter2.section2_1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread2_1
 * @Package cn.hdj.concurrency.progammingArt.chapter2
 * @Description: 测试线程
 * @date 2018/9/14 14:08
 */
public class MyThread2_1 extends Thread {


    private MySynchronizedObj mySynchronizedObj;

    public MyThread2_1(MySynchronizedObj mySynchronizedObj) {
        this.mySynchronizedObj = mySynchronizedObj;
    }

    @Override
    public void run() {
        super.run();
        try {
            mySynchronizedObj.test1(this.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MySynchronizedObj mySynchronizedObj = new MySynchronizedObj("abc");
        MyThread2_1 myThread2_1 = new MyThread2_1(mySynchronizedObj);
        myThread2_1.start();
        MyThread2_1 myThread2_2 = new MyThread2_1(mySynchronizedObj);
        myThread2_2.start();
    }
}
