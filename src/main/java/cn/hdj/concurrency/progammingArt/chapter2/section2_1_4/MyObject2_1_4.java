package cn.hdj.concurrency.progammingArt.chapter2.section2_1_4;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyObject2_1_4
 * @Package cn.hdj.concurrency.progammingArt.chapter2
 * @Description: TODO
 * @date 2018/9/14 14:27
 */
public class MyObject2_1_4 {

    public synchronized void methodA() {

        System.out.println("execute methodA the current thread name==" + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void methodB(){
        System.out.println("execute methodB the current thread name==" + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
