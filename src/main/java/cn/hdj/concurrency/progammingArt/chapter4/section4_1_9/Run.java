package cn.hdj.concurrency.progammingArt.chapter4.section4_1_9;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Run
 * @Package cn.hdj.concurrency.progammingArt.chapter4.section4_1_9
 * @Description: TODO
 * @date 2018/9/28 11:43
 */
public class Run {

    public static void main(String[] args) {
        Service service = new Service(false);

        new MyThread(service).start();
    }
}
