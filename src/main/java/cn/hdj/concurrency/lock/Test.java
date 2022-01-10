package cn.hdj.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author cloud-inman
 * @Date 2021/12/29 15:08
 */
public class Test {
    static int sign = 0;

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        new Thread(()->{
            for (int i = 0; i < 5; ) {
                lock.lock();
                if (sign % 3 == 0){
                    System.out.print("a");
                    sign++;
                    i++;
                }
                lock.unlock();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 5;) {
                lock.lock();
                if (sign % 3 == 1){
                    System.out.print("b");
                    sign++;
                    i++;
                }
                lock.unlock();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 5; ) {
                lock.lock();
                if (sign % 3 == 2){
                    System.out.print("c");
                    sign++;
                    i++;
                }
                lock.unlock();
            }
        }).start();
    }
}
