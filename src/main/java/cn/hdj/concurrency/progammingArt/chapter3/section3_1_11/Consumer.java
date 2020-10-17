package cn.hdj.concurrency.progammingArt.chapter3.section3_1_11;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Consumer
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_11
 * @Description: 消费者线程
 * @date 2018/9/26 12:50
 */
public class Consumer extends Thread {


    private List<String> data;

    public Consumer(List<String> data) {
        this.data = data;
    }

    @Override
    public void run() {
        super.run();
        while (true)
            consumer();
    }

    public void consumer() {

        try {
            synchronized (data) {
                if (data.size() == 1) {
                    data.wait();
                }
                TimeUnit.SECONDS.sleep(3);
                String remove = data.remove(data.size() - 1);
                System.out.println("data size=" + data.size());
                System.out.println("remove value = " + remove);
                data.notify();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
