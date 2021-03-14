package cn.hdj.jvm.gc;

/**
 * @Description: 空间分配担保  请在 JDK 6Update 24 之前运行
 * <p>
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure
 * @Author hdj
 * @Date 2021/2/28 下午12:38
 */
public class HandlePromotionFailureTest {

    public static final int _1M = 1024 * 1024;

    public static void main(String[] args) {

        byte[] allocate1;
        byte[] allocate2;
        byte[] allocate3;
        byte[] allocate4;
        byte[] allocate5;
        byte[] allocate6;
        byte[] allocate7;

        allocate1 = new byte[_1M * 2];
        allocate2 = new byte[_1M * 2];
        allocate3 = new byte[_1M * 2];
        allocate1 = null;
        allocate4 = new byte[_1M * 2];
        allocate5 = new byte[_1M * 2];
        allocate6 = new byte[_1M * 2];
        allocate4 = null;
        allocate5 = null;
        allocate6 = null;
        allocate7 = new byte[_1M * 2];
    }
}
