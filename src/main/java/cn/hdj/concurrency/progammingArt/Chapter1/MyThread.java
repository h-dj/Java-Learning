package cn.hdj.concurrency.progammingArt.Chapter1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread
 * @Package cn.hdj.concurrency.progammingArt.Chapter1
 * @Description: 继承Thread创建线程
 * @date 2018/8/8 12:54
 */
public class MyThread extends Thread {

    private int count;

    public MyThread(String name, int count) {
        super(name);
        this.count = count;
    }

    /**
     * 重写run方法
     */
    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println(" this calc by " + Thread.currentThread().getName() + " 计算 count-->" + count);
        }
    }
}
