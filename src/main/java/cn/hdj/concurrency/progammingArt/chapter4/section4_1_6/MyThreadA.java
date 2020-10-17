package cn.hdj.concurrency.progammingArt.chapter4.section4_1_6;


/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThreadA
 * @Package cn.hdj.concurrency.progammingArt.chapter4.section4_1_3
 * @Description: TODO
 * @date 2018/9/28 10:30
 */
public class MyThreadA extends Thread {


    private Service service;

    public MyThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.await_A();
    }

}
