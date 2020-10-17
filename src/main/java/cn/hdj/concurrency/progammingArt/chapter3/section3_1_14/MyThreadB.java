package cn.hdj.concurrency.progammingArt.chapter3.section3_1_14;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThreadA
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_14
 * @Description: TODO
 * @date 2018/9/26 16:59
 */
public class MyThreadB extends Thread {

    private DBtools dBtools;

    public MyThreadB(DBtools dBtools) {
        this.dBtools = dBtools;
    }

    @Override
    public void run() {
        super.run();
        dBtools.backB();
    }
}
