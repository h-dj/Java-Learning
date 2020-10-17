package cn.hdj.concurrency.progammingArt.chapter3.section3_3_2;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Run
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_3_2
 * @Description: TODO
 * @date 2018/9/27 14:32
 */
public class Run {

    public static void main(String[] args) {
        MyThreadA myThreadA = new MyThreadA();
        MyThreadC myThreadC = new MyThreadC();

        myThreadA.start();
        myThreadC.start();

       // Tools.tl.set("Main i =" + 00000111);

        System.out.println("Main i =" + Tools.tl.get());




    }
}
