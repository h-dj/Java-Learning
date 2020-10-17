package cn.hdj.concurrency.progammingArt.chapter4.section4_1_10;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author h_dj
 * @version V1.0
 * @Title: HoldCountTest
 * @Package cn.hdj.concurrency.progammingArt.chapter4.section4_1_9
 * @Description: TODO
 * @date 2018/9/28 11:39
 */
public class HoldCountTest {


    private ReentrantLock lock=lock = new ReentrantLock();

    public HoldCountTest() {
    }

    public void print() {

        try {
            lock.lock();
            System.out.println("获取锁" + Thread.currentThread().getName());
            System.out.println("持有锁的数量："+lock.getHoldCount());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("持有锁的数量："+lock.getHoldCount());
        }

    }


    public static void main(String[] args) {
        HoldCountTest service=new HoldCountTest();
        service.print();
    }
}
