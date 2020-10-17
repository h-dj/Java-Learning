package cn.hdj.concurrency.progammingArt.chapter4.section4_1_1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Service
 * @Package cn.hdj.concurrency.progammingArt.chapter4.section4_1_1
 * @Description: 测试ReentrantLock
 * @date 2018/9/28 9:57
 */
public class Service {

    private Lock lock = new ReentrantLock();

    public void print() {
        //锁住
        lock.lock();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " i= " + i);
        }
        //解锁
        lock.unlock();
    }
}
