package cn.hdj.concurrency.progammingArt.chapter3.section3_2_5;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Run
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_2_5
 * @Description: TODO
 * @date 2018/9/27 13:42
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {


        MyThreadB myThreadB=new MyThreadB();

        MyThreadA myThreadA=new MyThreadA(myThreadB);
        myThreadA.start();

        Thread.sleep(1000);

        MyThreadC myThreadC=new MyThreadC(myThreadB);

        myThreadC.start();


    }
}
