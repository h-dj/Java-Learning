package cn.hdj.concurrency.progammingArt.chapter3.section3_1_14;

/**
 * @author h_dj
 * @version V1.0
 * @Title: DBtools
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_14
 * @Description: TODO
 * @date 2018/9/26 16:46
 */
public class DBtools {

    // 备份数据库标识，true备份A数据库，false备份B数据库
    private volatile boolean prevIsA = false;

    public synchronized void backA() {
        try {
            while (prevIsA == true) {
                this.wait();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println("备份数据到数据库A");
            }
            prevIsA = true;
            notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void backB() {
        try {
            while (prevIsA == false) {
                this.wait();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println("备份数据到数据库B");
            }
            prevIsA = false;
            notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
