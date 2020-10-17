package cn.hdj.concurrency.progammingArt.chapter3.section3_2_5;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThreadA
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_2_5
 * @Description: TODO
 * @date 2018/9/27 11:43
 */
public class MyThreadA extends Thread {


    private MyThreadB myThreadB;


    public MyThreadA(MyThreadB myThreadB) {
        this.myThreadB = myThreadB;
    }

    @Override
    public void run() {
        super.run();
        try {
            //myThreadB.start();
            // Thread.sleep(5000);//不释放锁

            synchronized (myThreadB){
                myThreadB.start();
                myThreadB.join(); //释放锁
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    Math.random();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
