package cn.hdj.jvm.gc;

/**
 * @Description: 动态对象年龄判定
 *
 * <p>
 * 虚拟机参数:
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
 * @Author hdj
 * @Date 2021/2/1 下午11:29
 */
public class TenuringThresholdTest2 {

    public static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocate, allocate2, allocate3, allocate4;

        //内部占用 460K左右，注释allocate 和 allocate2的赋值， 在执行一次 MinorGC后，查看GC日志 5781K->461K(9216K)
        //因为这两个对象加起来已经到达了70K，并且它们是同年龄的，满足同年龄对象达到Survivor空间一半的规则
        //所以进入了老年代
        allocate = new byte[1024 * 35];
        //allocate2 = new byte[1024 * 35];

        allocate3 = new byte[_1M * 4];
        allocate4 = new byte[_1M * 4];
        allocate4 = null;
        allocate3 = new byte[_1M * 4];
    }
}
