package cn.hdj.concurrency.progammingArt.chapter3.section3_1_11;

import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: ConsumerThread
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_11
 * @Description: TODO
 * @date 2018/9/26 15:05
 */
public class ConsumerThread extends Thread {

    private MyStack myStack;

    public ConsumerThread(MyStack myStack) {
        this.myStack = myStack;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            myStack.pop();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
