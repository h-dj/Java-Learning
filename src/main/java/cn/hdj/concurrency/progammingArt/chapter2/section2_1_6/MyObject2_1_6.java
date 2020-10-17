package cn.hdj.concurrency.progammingArt.chapter2.section2_1_6;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyObject2_1_6
 * @Package cn.hdj.concurrency.progammingArt.chapter2
 * @Description: 测试锁重入
 * @date 2018/9/14 14:55
 */
public class MyObject2_1_6 {

    public synchronized void methodA() {

        System.out.println("execute methodA the current thread name==" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
            System.out.println("end");
            methodB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void methodB() {

        System.out.println("execute methodB the current thread name==" + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
