package cn.hdj.concurrency.progammingArt.Chapter1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Run
 * @Package cn.hdj.concurrency.progammingArt.Chapter1
 * @Description: TODO
 * @date 2018/8/8 13:03
 */
public class Run {


    public static void main(String[] args) {
        //  多线程计算，不共享数据
//        new MyThread("a",10).start();
//        new MyThread("b",10).start();
//        new MyThread("c",10).start();
//        new MyThread("d",10).start();
//        new MyThread("e",10).start();


        //  多线程操作，共享数据；
        //  会出现非线程安全问题
        //  要给变量或方法加锁

//        MyThreadShare myThreadShare=new MyThreadShare(10);
//        Thread thread1=new Thread(myThreadShare,"thread1");
//        Thread thread2=new Thread(myThreadShare,"thread2");
//        Thread thread3=new Thread(myThreadShare,"thread3");
//        Thread thread4=new Thread(myThreadShare,"thread4");
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();








































    }
}
