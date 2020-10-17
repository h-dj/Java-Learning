package cn.hdj.concurrency.javaThinking.concurrency_21_2;

import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Daemons
 * @Package cn.hdj.concurrency.javaThinking
 * @Description 由后台线程派生出来的子线程也是守护线程
 * @date 2018/1/19 11:45
 */
public class Daemons {

    public static void main(String[] args) throws InterruptedException {
        //// TODO: 2018/1/19
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon()=" + d.isDaemon());
        TimeUnit.MILLISECONDS.sleep(1);
    }
}

class Daemon implements Runnable {

    private Thread[] t = new Thread[10];

    @Override
    public void run() {

        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("Deamon.Run  DaemonSpawn " + i + " start");
        }
        for (int i = 0; i < t.length; i++) {
            //t[i].isDaemon()判断线程是否是后台线程
            System.out.println("t[" + i + "].isDaemon()=" + t[i].isDaemon() + " ,  ");
        }
        while (true) {
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {

    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}