package cn.hdj.jvm.gc;

import cn.hdj.Utils;

/**
 * @Description: PretenureSizeThreshold 测试
 * <p>
 * jvm args :
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC
 * -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 * @Author hdj
 * @Date 2021/2/1 下午11:10
 */
public class PretenureSizeThresholdTest {

    public static void main(String[] args) {
        byte[] allocate;
        allocate = new byte[4 * Utils._1M];
    }
}
