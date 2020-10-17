package cn.hdj.concurrency.javaThinking.concurrency_21_2;

/**
 * @author h_dj
 * @version V1.0
 * @Title: thread_21_2_1
 * @Package cn.hdj.concurrency.javaThinking
 * @Description: 创建线程方式一   实现Runnable接口 ，重写run方法
 * @date 2018/1/18 15:40
 */
public class thread_21_2_1 {

    public static void main(String[] args) {
        //// TODO: 2018/1/18
        //这里由main单一线程创建多个线程
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new LiftOff());
            thread.start();
        }
        System.out.println("warning");
    }

}

