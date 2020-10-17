package cn.hdj.concurrency.progammingArt.chapter2.section2_1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MySynchronizedObj
 * @Package cn.hdj.concurrency.progammingArt.chapter2
 * @Description: synchronized 同步 ; synchronized持有的是对象锁
 * @date 2018/9/14 14:00
 */
public class MySynchronizedObj {

    private String name;

    public MySynchronizedObj(String name) {
        this.name = name;
    }

    //同步方法
    //同一时间只能有一个线程访问该方法
    public synchronized void test() {
    }

    public void test1(String arg) throws InterruptedException {
        //非同步区
        System.out.println(this.name + "进入test1方法");
        //同一时间只能有一个线程访问该代码块
        //括号中可以是
        synchronized (name) {
            //同步代码块
            System.out.println("进入同步代码块");
            Thread.sleep(5000);
            System.out.println("执行完成！");
        }


    }
}
