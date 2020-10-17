package cn.hdj.concurrency.progammingArt.Chapter1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread1_8_1
 * @Package cn.hdj.concurrency.progammingArt.Chapter1
 * @Description: 暂停和恢复线程
 * @date 2018/9/10 11:27
 */
public class MyThread1_8_1 extends Thread {

    private long i;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            i++;
        }
    }

    public static void main(String[] args) {

        MyThread1_8_1 myThread1_8_1 = new MyThread1_8_1();
        myThread1_8_1.start();

        try {
            Thread.sleep(5000);
            //暂停
            myThread1_8_1.suspend();
            System.out.println("A" + System.currentTimeMillis() + " " + myThread1_8_1.getI());


            myThread1_8_1.resume();

            Thread.sleep(5000);
            myThread1_8_1.suspend();
            System.out.println("B" + System.currentTimeMillis() + " " + myThread1_8_1.getI());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
