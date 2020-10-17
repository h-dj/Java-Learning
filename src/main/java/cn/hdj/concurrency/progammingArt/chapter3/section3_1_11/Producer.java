package cn.hdj.concurrency.progammingArt.chapter3.section3_1_11;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Producer
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_11
 * @Description: 生产消费者模式之生产者
 * @date 2018/9/26 11:43
 */
public class Producer extends Thread {


    private List<String> data;

    public Producer(List<String> data) {
        this.data = data;
    }


    @Override
    public void run() {
        super.run();

        while (true)
            produce();
    }

    public void produce() {

        try {
            synchronized (data) {
                if (data != null && data.size() > 1) {
                    data.wait();
                }
                TimeUnit.SECONDS.sleep(3);
                data.add("value= " + Math.random());
                System.out.println("data size=" + data.size());
                data.notify();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
