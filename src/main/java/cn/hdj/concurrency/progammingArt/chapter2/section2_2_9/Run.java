package cn.hdj.concurrency.progammingArt.chapter2.section2_2_9;

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
        Service service = new Service();

        MyThreadA myThreadA = new MyThreadA(service);
        MyThreadB myThreadB = new MyThreadB(service);
        MyThreadC myThreadC = new MyThreadC(service);
        MyThreadD myThreadD = new MyThreadD(service);
        MyThreadE myThreadE = new MyThreadE(service);
        MyThreadA myThreadAA = new MyThreadA(new Service());

        myThreadA.setName("A");
        myThreadAA.setName("AA");
        myThreadB.setName("B");
        myThreadC.setName("C");
        myThreadE.setName("E");
        myThreadD.setName("D");

        myThreadA.start();
        myThreadB.start();
        myThreadC.start();
        myThreadE.start();
        myThreadD.start();
        myThreadAA.start();

    }
}
