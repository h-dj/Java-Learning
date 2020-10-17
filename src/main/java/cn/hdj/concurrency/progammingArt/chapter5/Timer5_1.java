package cn.hdj.concurrency.progammingArt.chapter5;

import java.util.Timer;
import java.util.TimerTask;

public class Timer5_1 {


    public static void main(String[] args) throws InterruptedException {
        Timer timer=new Timer();

        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                System.out.println("timerTask执行任务");
            }
        };
        TimerTask timerTask2=new TimerTask() {
            @Override
            public void run() {
                System.out.println("timerTask2执行任务");
            }
        };

        timer.schedule(timerTask,3);
        timer.schedule(timerTask2,1);

    }
}
