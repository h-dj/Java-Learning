package cn.hdj.concurrency.progammingArt.Chapter1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyStopThread
 * @Package cn.hdj.concurrency.progammingArt.Chapter1
 * @Description: 停止不了的线程
 * @date 2018/8/10 13:31
 */
public class MyStopThread extends Thread {

    @Override
    public void run() {
        super.run();

        for (int i = 1; i <= 10000; i++) {
            System.out.println("i=" +i);
        }
    }

    public static void main(String[] args){
        //// TODO: 2018/8/10

        try {
            MyStopThread myStopThread = new MyStopThread();
            myStopThread.start();
            Thread.sleep(2);
            /**
             * 虽然调用线程.interrupt() 来停止线程
             * 但却没能停止
             */
            myStopThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();



        }
    }
}
