package cn.hdj.concurrency.progammingArt.chapter2.section2_1_6;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread2_1_6_1
 * @Package cn.hdj.concurrency.progammingArt.chapter2
 * @Description: TODO
 * @date 2018/9/14 14:56
 */
public class MyThread2_1_6_1 extends Thread {

    public MyObject2_1_6 myObject2_1_6;

    public MyThread2_1_6_1() {
    }

    public MyThread2_1_6_1(MyObject2_1_6 myObject2_1_6) {
        this.myObject2_1_6 = myObject2_1_6;
    }

    @Override
    public void run() {
        super.run();
        myObject2_1_6.methodA();

    }

    public static void main(String[] args){
        MyObject2_1_6 myObject2_1_6=new MyObject2_1_6();
        MyThread2_1_6_1 myThread2_1_6_1=new MyThread2_1_6_1(myObject2_1_6);
        myThread2_1_6_1.setName("myThread2_1_6_1");
        MyThread2_1_6_2 myThread2_1_6_2=new MyThread2_1_6_2(myObject2_1_6);
        myThread2_1_6_2.setName("myThread2_1_6_2");
        myThread2_1_6_1.start();
        myThread2_1_6_2.start();
    }
}
