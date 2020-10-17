package cn.hdj.concurrency.progammingArt.chapter4.section4_1_9;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Service
 * @Package cn.hdj.concurrency.progammingArt.chapter4.section4_1_9
 * @Description: TODO
 * @date 2018/9/28 11:39
 */
public class Service {


    private ReentrantLock lock;

    public Service(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void print() {

        try {
            lock.lock();
           // lock.lock();
            System.out.println("获取锁" + Thread.currentThread().getName());
            System.out.println("持有锁的数量："+lock.getHoldCount());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
          //  lock.unlock();
            System.out.println("持有锁的数量："+lock.getHoldCount());
        }

    }
}
