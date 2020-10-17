package cn.hdj.concurrency.progammingArt.Chapter1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread1_8_2
 * @Package cn.hdj.concurrency.progammingArt.Chapter1
 * @Description: 暂停恢复线程---缺点： 独占同步对象，造成死锁
 * @date 2018/9/10 22:37
 */
public class MyThread1_8_2 {

    public static void main(String[] args) {

        SynchronizedObj1_8_2 synchronizedObj1_8_2 = new SynchronizedObj1_8_2();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                super.run();

                synchronizedObj1_8_2.print();
            }
        };

        thread1.setName("a");
        thread1.start();

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                super.run();

                System.out.println("synchronizedObj1_8_2对象被线程a锁住，其它线程访问不了 ");

                synchronizedObj1_8_2.print();
                System.out.println("因为线程a正在暂停线程");
            }
        };

        thread2.start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.resume();
    }

}
