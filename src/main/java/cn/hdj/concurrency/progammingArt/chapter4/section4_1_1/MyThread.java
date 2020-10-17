package cn.hdj.concurrency.progammingArt.chapter4.section4_1_1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread
 * @Package cn.hdj.concurrency.progammingArt.chapter4.section4_1_1
 * @Description: TODO
 * @date 2018/9/28 10:03
 */
public class MyThread extends Thread {

    private Service service;

    public MyThread(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.print();
    }

    public static void main(String[] args) {

        Service service = new Service();
        MyThread a = new MyThread(service);
        MyThread a1 = new MyThread(service);
        MyThread a2 = new MyThread(service);
        MyThread a3 = new MyThread(service);
        MyThread a4 = new MyThread(service);
        MyThread a5 = new MyThread(service);


        a.start();

        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();


    }
}
