package cn.hdj.jvm.gc;

/**
 * @Description: 设置对象晋升老年代的年龄阈值
 * <p>
 * 虚拟机参数:
 * <p>
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 * <p>
 * 提升Survivor 空间  或者 减少 allocate 分配的内存大小， 就和书中例子差不多
 * -verbose:gc -Xms40M -Xmx40M -Xmn20M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 * @Author hdj
 * @Date 2021/2/1 下午11:29
 */
public class TenuringThresholdTest {

    public static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocate, allocate2, allocate3;
        allocate = new byte[_1M / 4];
//        //什么时候进入老年代取决于XX:MaxTenuringThreshold设置
        allocate2 = new byte[_1M * 4 ];
//        allocate3 = new byte[_1M * 4 ];
//        allocate3 = null;
//        allocate3 = new byte[_1M * 4];


        //减少 allocate 分配的内存大小
//        allocate = new byte[_1M / 16];
//        allocate2 = new byte[_1M * 4 ];
//        allocate3 = new byte[_1M * 4 ];
//        allocate3 = null;
//        allocate3 = new byte[_1M * 4];


        //提升提升Survivor 空间
//        allocate = new byte[_1M / 2];
//        allocate2 = new byte[_1M * 8];
//        allocate3 = new byte[_1M * 8];
//        allocate3 = null;
//        allocate3 = new byte[_1M * 8];
    }
}
