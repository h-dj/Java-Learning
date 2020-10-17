package cn.hdj.concurrency.javaThinking.concurrency_21_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author h_dj
 * @version V1.0
 * @Title: CacheThreadPool
 * @Package cn.hdj.concurrency.javaThinking
 * @Description: 了解Executors 创建和管理线程
 * @date 2018/1/18 16:16
 */
public class CacheThreadPool {

    public static void main(String[] args) {
        //// TODO: 2018/1/18
        //创建线程执行器服务
        //使用Executors工具类的静态方法，创建缓存可复用的线程池
        //ExecutorService executorService = Executors.newCachedThreadPool();
        //创建固定线程的线程池，在创建时，就要规定创建的线程数
        // ExecutorService executorService = Executors.newFixedThreadPool(5);
        //创建单一的线程池，会按照任务的提交顺序执行，直到任务完成，才执行下一个任务
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        //防止新的任务提交给Executor
        executorService.shutdown();
    }
}
