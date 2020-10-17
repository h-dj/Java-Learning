package cn.hdj.concurrency.progammingArt.chapter2.section2_1_4;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread2_1_4
 * @Package cn.hdj.concurrency.progammingArt.chapter2
 * @Description: synchronized 方法和对象锁
 * @date 2018/9/14 14:26
 */
public class MyThread2_1_4 extends Thread {


    private MyObject2_1_4 myObject2_1_4;

    public MyThread2_1_4(MyObject2_1_4 myObject2_1_4) {
        this.myObject2_1_4 = myObject2_1_4;
    }


    @Override
    public void run() {
        super.run();
        this.myObject2_1_4.methodB();
    }

    public static void main(String[] args){
        MyObject2_1_4 myObject2_1_4=new MyObject2_1_4();

        MyThread2_1_4 abc=new MyThread2_1_4(myObject2_1_4);
        abc.setName("abc");

        MyThread2_1_4 cbd=new MyThread2_1_4(myObject2_1_4);
        cbd.setName("cbd");

        abc.start();
        cbd.start();
    }
}
