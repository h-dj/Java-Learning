package cn.hdj.concurrency.progammingArt.Chapter1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread2
 * @Package cn.hdj.concurrency.progammingArt.Chapter1
 * @Description: TODO
 * @date 2018/8/8 13:16
 */
public class MyThread2 implements Runnable {
    /**
     * 实现 Runnable接口
     * 重写run方法
     */
    @Override
    public void run() {
        System.out.println("执行run");
    }
}
