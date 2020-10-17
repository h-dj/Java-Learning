package cn.hdj.concurrency.progammingArt.chapter2.section2_3_6;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread
 * @Package cn.hdj.concurrency.progammingArt.chapter2.section2_3_6
 * @Description: TODO
 * @date 2018/9/21 14:46
 */
public class MyThread extends Thread {

    private AtomCountTest atomCountTest;

    public MyThread(AtomCountTest atomCountTest) {
        this.atomCountTest = atomCountTest;
    }

    @Override
    public void run() {
        super.run();
        atomCountTest.addCount();

    }
}
