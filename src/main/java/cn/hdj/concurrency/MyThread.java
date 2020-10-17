package cn.hdj.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread
 * @Package cn.hdj.concurrency
 * @Description: TODO
 * @date 2018/3/17 21:38
 */
public class MyThread implements Runnable {

    private String who;//标识

    public MyThread() {
    }

    public MyThread(String who) {
        this.who = who;
    }

    @Override
    public void run() {
        //打印5次运行状态
        for (int i = 0; i < 5; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep((long) (1000 * Math.random()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            //打印
            System.out.println(who + "在运行");
        }
    }


}
