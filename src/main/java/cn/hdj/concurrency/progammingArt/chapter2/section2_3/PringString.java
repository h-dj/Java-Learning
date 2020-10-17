package cn.hdj.concurrency.progammingArt.chapter2.section2_3;

import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: PringString
 * @Package cn.hdj.concurrency.progammingArt.chapter2.section2_3
 * @Description: TODO
 * @date 2018/9/21 10:59
 */
public class PringString {

    private boolean isContinePrint = true;

    public boolean isContinePrint() {
        return isContinePrint;
    }

    public void setContinePrint(boolean continePrint) {
        isContinePrint = continePrint;
    }

    public void print() {
        while (isContinePrint == true) {
            System.out.println("print thread name= " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }


    }

    public static void main(String[] args) {
        PringString pringString = new PringString();

        pringString.print();

        System.out.println("stop print ThreadName=" + Thread.currentThread().getName());
        pringString.setContinePrint(false);
    }
}
