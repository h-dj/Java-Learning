package cn.hdj.concurrency.progammingArt.chapter3.section3_2_5;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThreadB
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_2_5
 * @Description: TODO
 * @date 2018/9/27 11:44
 */
public class MyThreadB extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println(" start begin time =" + System.currentTimeMillis());

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end time =" + System.currentTimeMillis());
    }

    public synchronized void printService() {
        System.out.println("enter printService time= " + System.currentTimeMillis()             );
    }
}
