package cn.hdj.concurrency.progammingArt.chapter3.section3_3_2;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThreadA
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_3_2
 * @Description: TODO
 * @date 2018/9/27 14:24
 */
public class MyThreadC extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            Tools.tl.set("MyThreadC i = " + i);
            System.out.println("MyThreadC i = " + Tools.tl.get());
        }
    }
}
