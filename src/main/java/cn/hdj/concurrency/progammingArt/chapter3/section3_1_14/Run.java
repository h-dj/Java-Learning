package cn.hdj.concurrency.progammingArt.chapter3.section3_1_14;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Run
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_14
 * @Description: TODO
 * @date 2018/9/26 17:04
 */
public class Run {

    public static void main(String[] args) {
        DBtools dBtools = new DBtools();

        for (int i = 0; i < 5; i++) {


            MyThreadB myThreadB = new MyThreadB(dBtools);
            myThreadB.start();


            MyThreadA myThreadA = new MyThreadA(dBtools);
            myThreadA.start();


        }
    }
}
