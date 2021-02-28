package cn.hdj.jvm.gc;

/**
 * @Description: 优先分配Eden
 * <p>
 * 虚拟机参数： 使用Serial加SerialOld客户端默认收集器组合下的内存分配和回收的策略(-XX:+UseSerialGC)
 * <pre>
 *     -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
 * </pre>
 *
 * @Author hdj
 * @Date 2021/1/10 下午5:01
 */
public class AllocationEden {

    public static final int _1M = 1024 * 1024;
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[2 * _1M];
        allocation2 = new byte[2 * _1M];
        allocation3 = new byte[2 * _1M];
        //出现一次minor GC
        allocation4 = new byte[4 * _1M];
    }
}
