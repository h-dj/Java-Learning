package cn.hdj.concurrency.progammingArt.chapter2.section2_3_6;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author h_dj
 * @version V1.0
 * @Title: AtomCountTest
 * @Package cn.hdj.concurrency.progammingArt.chapter2.section2_3_6
 * @Description: TODO
 * @date 2018/9/21 14:19
 */
public class AtomCountTest {

    public static AtomicLong atomicLong = new AtomicLong(0);

    public void addCount() {
        System.out.println("当前线程 原子类加到100" + atomicLong.addAndGet(100));

        atomicLong.addAndGet(1);
    }
}
