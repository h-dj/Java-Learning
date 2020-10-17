package cn.hdj.concurrency.progammingArt.chapter3.section3_1_11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyStack
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_11
 * @Description: TODO
 * @date 2018/9/26 14:57
 */
public class MyStack {

    private List<String> data = new ArrayList<>();

    public synchronized void push() {
        try {
            while (data.size() == 1) {
                this.wait();
            }
            data.add("value= " + Math.random());
            System.out.println(Thread.currentThread().getName() + " data size=" + data.size());
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void pop() {
        try {
            while (data.size() == 0) {
                this.wait();
            }

            String popValue = data.remove(data.size() - 1);
            System.out.println(Thread.currentThread().getName() + " data size=" + data.size() + " popValue= " + popValue);
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
