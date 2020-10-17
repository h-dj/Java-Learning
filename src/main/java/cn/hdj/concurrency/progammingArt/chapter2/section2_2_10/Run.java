package cn.hdj.concurrency.progammingArt.chapter2.section2_2_10;


/**
 * @author h_dj
 * @version V1.0
 * @Title: Run
 * @Package cn.hdj.concurrency.progammingArt.chapter2.section2_2_9
 * @Description: TODO
 * @date 2018/9/20 11:45
 */
public class Run {

    public static void main(String[] args) {


        ////String 常量池特性，造成一个线程占用（参数）String对象锁,而另一个线程访问不了Service 中methodA方法中的同步代码块

        MyThreadA myThreadA = new MyThreadA();
        MyThreadB myThreadB = new MyThreadB();

        myThreadA.setName("A");
        myThreadB.setName("B");

        myThreadA.start();
        myThreadB.start();


    }
}
