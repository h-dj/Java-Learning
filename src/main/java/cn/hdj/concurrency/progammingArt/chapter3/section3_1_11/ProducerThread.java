package cn.hdj.concurrency.progammingArt.chapter3.section3_1_11;

import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: ProducerThread
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_11
 * @Description: TODO
 * @date 2018/9/26 15:02
 */
public class ProducerThread extends Thread {

    private MyStack myStack;

    public ProducerThread(MyStack myStack) {
        this.myStack = myStack;
    }


    @Override
    public void run() {
        super.run();
        while (true){
            myStack.push();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
