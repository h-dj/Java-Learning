package cn.hdj.concurrency.javaThinking.concurrency_21_2;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: DaemonThreadPoolExecutor
 * @Package cn.hdj.concurrency.javaThinking
 * @Description: 守护线程池执行器
 * @date 2018/1/19 11:39
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {


    /**
     * corePoolSize    核心线程数量
     * maximumPoolSize 最大线程数量
     * keepAliveTime   线程存活时间
     * unit
     * workQueue       线程任务队列
     * threadFactory  线程工厂
     */
    public DaemonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE,
                60L,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new DaemonThreadFactory());
    }
}
