package cn.hdj.concurrency.progammingArt.Chapter1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: SynchronizedObj1_8_2
 * @Package cn.hdj.concurrency.progammingArt.Chapter1
 * @Description: TODO
 * @date 2018/9/10 22:44
 */
public class SynchronizedObj1_8_2 {

    public synchronized void print() {
        System.out.println("start");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a thread 永远暂停");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}
