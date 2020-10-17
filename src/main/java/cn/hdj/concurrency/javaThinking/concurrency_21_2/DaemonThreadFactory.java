package cn.hdj.concurrency.javaThinking.concurrency_21_2;

import java.util.concurrent.ThreadFactory;

/**
 * @author h_dj
 * @version V1.0
 * @Title: DaemonThreadFactory
 * @Package cn.hdj.concurrency.javaThinking
 * @Description: 创建守护线程的工厂类
 * @date 2018/1/19 11:26
 */
public class DaemonThreadFactory implements ThreadFactory {


    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
