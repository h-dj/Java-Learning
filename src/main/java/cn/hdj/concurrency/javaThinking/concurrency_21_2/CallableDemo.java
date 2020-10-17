package cn.hdj.concurrency.javaThinking.concurrency_21_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author h_dj
 * @version V1.0
 * @Title: CallableDemo
 * @Package cn.hdj.concurrency.javaThinking
 * @Description: TODO
 * @date 2018/1/18 17:00
 */
public class CallableDemo {

    public static void main(String[] args) {
        //// TODO: 2018/1/18
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futures.add(exec.submit(new TaskWithResult(i)));
        }

        for (Future future : futures) {
            if (future.isDone())
                try {
                    System.out.println(future.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } finally {
                    exec.shutdown();
                }
        }
    }
}
