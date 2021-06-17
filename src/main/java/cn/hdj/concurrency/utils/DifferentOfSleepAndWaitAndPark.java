package cn.hdj.concurrency.utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description: TODO(������һ�仰��������������)
 * @Author huangjiajian
 * @Date 2021/6/17 12:17
 */
public class DifferentOfSleepAndWaitAndPark {

    public static void main(String[] args) throws InterruptedException {
//        test_sleep();
//        test_sleep_lock_lose();

//        test_wait();
//        test_wait_timeout();

        test_park();
    }



    public static void test_sleep() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "ִ����ɣ�");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "�߳�A").start();
        System.out.println("ִ�б��߳�A��");
    }

    /**
     * ����Thread.sleep �Ƿ���ͷ���: ����
     */
    public static void test_sleep_lock_lose() {

        final Object lock = new Object();

        new Thread(() -> {
            try {
                synchronized (lock){
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "ִ����ɣ�");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "�߳�A").start();

        new Thread(() -> {
            try {
                synchronized (lock){
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "ִ����ɣ�");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "�߳�B").start();
    }

    /**
     * ���� Object.wait()��ʹ�ã����Ƿ��ͷ����� ���ͷ���
     */
    public static void test_wait(){
        final Object lock = new Object();

        Thread threadA = new Thread(() -> {
            try {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "��ʼִ��");
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName() + "ִ����ɣ�");
                    //�����߳�B
                    lock.notify();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "�߳�A");

        Thread threadB = new Thread(() -> {
            try {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "����");
                    //�ͷ������߳̿�ʼ��ȡ��
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + "ִ����ɣ�");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "�߳�B");


        threadB.start();
        threadA.start();
    }

    /**
     * wait ��ʱ�ͷ���
     */
    public static void test_wait_timeout(){
        final Object lock = new Object();

        Thread threadA = new Thread(() -> {
            try {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "��ʼִ��");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "ִ����ɣ�");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "�߳�A");

        Thread threadB = new Thread(() -> {
            try {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "���𣡳�ʱ5��");
                    //5������»�ȡ��������ִ��
                    lock.wait(5000);
                    System.out.println(Thread.currentThread().getName() + "ִ����ɣ�");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "�߳�B");


        threadB.start();
        threadA.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("�߳�A��ǰ״̬"+threadA.getState().name());
        System.out.println("�߳�B��ǰ״̬"+threadB.getState().name());
    }

    /**
     * ����LockSupport.park �����߳�
     */
    public static void test_park(){
        Thread threadA = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "����");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "ִ����ɣ�");
        }, "�߳�A");

        threadA.start();
        try {
            System.out.println("���߳�˯��5��");
            TimeUnit.SECONDS.sleep(5);
            //�����߳�A
            LockSupport.unpark(threadA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
