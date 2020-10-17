package cn.hdj.concurrency.progammingArt.chapter3.section3_2_5;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThreadC
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_2_5
 * @Description: TODO
 * @date 2018/9/27 13:43
 */
public class MyThreadC extends Thread {

    private MyThreadB myThreadB;

    public MyThreadC(MyThreadB myThreadB) {
        this.myThreadB = myThreadB;
    }

    @Override
    public void run() {
        super.run();
        myThreadB.printService();

    }
}
