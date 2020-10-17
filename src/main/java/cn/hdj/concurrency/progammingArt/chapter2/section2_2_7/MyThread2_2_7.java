package cn.hdj.concurrency.progammingArt.chapter2.section2_2_7;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread2_2_7
 * @Package cn.hdj.concurrency.progammingArt.chapter2
 * @Description: 任意对象作为同步锁
 * @date 2018/9/19 17:18
 */
public class MyThread2_2_7 extends Thread{

    private Service2_2_7 service2_2_7;
    private String name;
    private String password;

    public MyThread2_2_7(Service2_2_7 service2_2_7) {
        this.service2_2_7 = service2_2_7;
    }

    public void setUp(String name,String password){
        this.name=name;
        this.password=password;
    }

    @Override
    public void run() {
        super.run();
        this.service2_2_7.method2();
        this.service2_2_7.setUsernameAndPassword(this.name,this.password);
    }

    public static void main(String[] args){
        Service2_2_7 service2_2_7=new Service2_2_7();

        MyThread2_2_7 a=new MyThread2_2_7(service2_2_7);
        a.setUp("123","456");
        a.setName("a");
        a.start();

        MyThread2_2_7 b=new MyThread2_2_7(service2_2_7);
        b.setUp("abc","def");
        b.setName("b");
        b.start();
    }
}
