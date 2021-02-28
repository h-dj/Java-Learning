package cn.hdj;

/**
 * @Description: 相关辅助工具
 * @Author hdj
 * @Date 2021/1/10 下午5:32
 */
public final class Utils {

    public static final int _1M = 1024 * 1024;

    //打印内存
    public static void printlnMemory(String tag) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("\n" + tag + ":");
        System.out.println(runtime.freeMemory() / _1M + "M(free)/" + runtime.totalMemory() / _1M + "M(total)");
    }

}
