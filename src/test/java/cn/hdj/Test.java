package cn.hdj;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author huangjiajian
 * @Date 2022/5/26 17:37
 */
public class Test {

    public static void main(String[] args) {
        Utils.printlnMemory("test");
        int[] a = new int[6375 * 8775];
        Utils.printlnMemory("test");

        System.out.println(a.length);

    }
}
