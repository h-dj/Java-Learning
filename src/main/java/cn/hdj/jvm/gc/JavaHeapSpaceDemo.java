package cn.hdj.jvm.gc;

/**
 * @Description: 堆溢出  -Xmx8m -Xms8m
 * @Author huangjiajian
 * @Date 2022/3/14 10:12
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        byte[] bytes = new byte[8 * 1014 * 1024];
    }
}
