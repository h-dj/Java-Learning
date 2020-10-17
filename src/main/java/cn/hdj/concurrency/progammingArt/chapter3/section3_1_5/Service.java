package cn.hdj.concurrency.progammingArt.chapter3.section3_1_5;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Service
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_5
 * @Description: TODO
 * @date 2018/9/26 10:39
 */
public class Service {


    public void testMethod(Object lock){
        synchronized (lock){
            System.out.println("the current Thread name"+ Thread.currentThread().getName()+ " enter");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("the current Thread name"+ Thread.currentThread().getName()+ " exit ");
        }
    }
}
