package cn.hdj.concurrency.progammingArt.Chapter1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread1_7_5
 * @Package cn.hdj.concurrency.progammingArt.Chapter1
 * @Description: 使用stop 停止线程，造成释放锁后数据丢失问题
 * @date 2018/9/10 11:05
 */
public class MyThread1_7_5 extends Thread {

    private SynchronizedObj1_7_5 synchronizedObj;

    public MyThread1_7_5(SynchronizedObj1_7_5 synchronizedObj) {
        this.synchronizedObj = synchronizedObj;
    }

    @Override
    public void run() {
        super.run();
        this.synchronizedObj.pringString("1230", "78963");
    }


    public static void main(String[] args) {

        SynchronizedObj1_7_5 synchronizedObj = new SynchronizedObj1_7_5();
        MyThread1_7_5 myThread1_7_5 = new MyThread1_7_5(synchronizedObj);
        myThread1_7_5.start();
        try {
            Thread.sleep(5000);
            myThread1_7_5.stop();

            System.out.println(synchronizedObj.getUsername() + " " + synchronizedObj.getPassword());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}


