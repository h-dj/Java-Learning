package cn.hdj.concurrency.progammingArt.chapter2.section2_2_10;


/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread
 * @Package cn.hdj.concurrency.progammingArt.chapter2.section2_2_9
 * @Description: TODO
 * @date 2018/9/20 11:34
 */
public class MyThreadB extends Thread {


    public static Object o = new Object();

    @Override
    public void run() {
        super.run();
        Service.methodA("123");
    }
}
