package cn.hdj.concurrency.progammingArt.chapter4.section4_1_3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Service
 * @Package cn.hdj.concurrency.progammingArt.chapter4.section4_1_3
 * @Description: 使用condition实现等待通知机制
 * @date 2018/9/28 10:27
 */
public class Service {

    //可重入锁
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await() {
        try {
            lock.lock();

            System.out.println(" start wait");
            //再调用等待时，必须先获取对象锁
            condition.await();
            System.out.println("end wait");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("end lock");
        }
    }

    public void signal() {

        try {
            lock.lock();
            System.out.println("signal time = " + System.currentTimeMillis());
            condition.signal();
        } finally {
            lock.unlock();
        }
        System.out.println("end signal ");
    }
}
