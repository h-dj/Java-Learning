package cn.hdj.concurrency.progammingArt.chapter4.section4_1_6;

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

    //创建多个condition
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public void await_A() {
        try {
            lock.lock();

            System.out.println(" start wait" + Thread.currentThread().getName());
            //再调用等待时，必须先获取对象锁
            conditionA.await();
            System.out.println("end wait" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("end lock" + Thread.currentThread().getName());
        }
    }

    public void await_B() {
        try {
            lock.lock();

            System.out.println(" start wait" + Thread.currentThread().getName());
            //再调用等待时，必须先获取对象锁
            conditionB.await();
            System.out.println("end wait" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("end lock" + Thread.currentThread().getName());
        }
    }

    public void signalAll_A() {

        try {
            lock.lock();
            System.out.println("signal time = " + System.currentTimeMillis() + Thread.currentThread().getName());
            //唤醒持有conditonA锁的线程
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
        System.out.println("end signal " + Thread.currentThread().getName());
    }

    public void signalAll_B() {

        try {
            lock.lock();
            System.out.println("signal time = " + System.currentTimeMillis() + Thread.currentThread().getName());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
        System.out.println("end signal " + Thread.currentThread().getName());
    }
}
