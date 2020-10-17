package cn.hdj.concurrency.progammingArt.Chapter1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread1_7_2
 * @Package cn.hdj.concurrency.progammingArt.Chapter1
 * @Description: 判断线程是否是停止状态
 * @date 2018/8/15 15:21
 */
public class MyThread1_7_2 extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10000; i++) {
            System.out.println("线程run -->" + i);
        }
    }



}
