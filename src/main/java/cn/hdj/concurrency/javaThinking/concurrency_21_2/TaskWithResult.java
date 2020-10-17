package cn.hdj.concurrency.javaThinking.concurrency_21_2;

import java.util.concurrent.Callable;

/**
 * @author h_dj
 * @version V1.0
 * @Title: TaskWithResult
 * @Package cn.hdj.concurrency.javaThinking
 * @Description: 带返回值的任务, 实现Callable接口 在call方法中返回结果
 * 执行时，需要执行器ExecutorService 调用exec.submit(new TaskWithResult(i)来提交任务
 * 此方法会返回Future带结果的类，调用该类中的get即可获取返回的结果，
 * 在调用get获取结果时，可以先调用isDone()方法查看任务是否执行完毕，如果不调用此方法，
 * get()方法会一直阻塞，直到结果已准备好
 *
 * @date 2018/1/18 16:58
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "return result of TaskWithResult" + id;
    }
}
