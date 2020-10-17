package cn.hdj.concurrency.progammingArt.chapter3.section3_2;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Run
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_2
 * @Description: TODO
 * @date 2018/9/27 9:33
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread=new MyThread();

        myThread.start();

        myThread.join();
        System.out.println("等待 mythread 执行完才执行！");
    }
}
