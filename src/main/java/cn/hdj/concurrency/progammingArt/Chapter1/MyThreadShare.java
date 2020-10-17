package cn.hdj.concurrency.progammingArt.Chapter1;

/**
 * @author h_dj
 * @version V1.0
 * @Title: MyThread
 * @Package cn.hdj.concurrency.progammingArt.Chapter1
 * @Description: TODO
 * @date 2018/8/8 12:54
 */
public  class  MyThreadShare extends Thread {
    private  int count;
    public  MyThreadShare(int count) {
        this.count = count;
    }
    @Override
    public synchronized void run() {

        //  对count进行减法操作
        --count;
        System.out.println(" this calc by " + Thread.currentThread().getName() + " 计算 count-->" + count);
    }
}
