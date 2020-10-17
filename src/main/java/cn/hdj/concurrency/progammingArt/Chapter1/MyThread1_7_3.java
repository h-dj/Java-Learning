package cn.hdj.concurrency.progammingArt.Chapter1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread1_7_3
 * @Package cn.hdj.concurrency.progammingArt.Chapter1
 * @Description: TODO
 * @date 2018/8/25 12:59
 */
public class MyThread1_7_3 extends Thread {


    @Override
    public void run() {
        super.run();

        try {
            for (int i = 0; i < 500000; i++) {

                if(this.interrupted()){
                    System.out.println("我被打断");
                    throw  new InterruptedException();
                }
                System.out.println("i="+i);
            }

            System.out.println(" for循环下面");
        } catch (InterruptedException e) {
            System.out.println("线程被打断！");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            MyThread1_7_3 myThread1_7_3=new MyThread1_7_3();
            myThread1_7_3.start();
            myThread1_7_3.sleep(2000);
            myThread1_7_3.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");

    }
}
