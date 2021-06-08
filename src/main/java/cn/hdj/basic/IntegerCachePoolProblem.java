package cn.hdj.basic;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author huangjiajian
 * @Date 2021/6/2 15:21
 * <p>
 * Integer 缓存池问题
 * 在jvm 启动时，可以配置-XX:AutoBoxCacheMax=<size> 来设置缓存池大小
 */
public class IntegerCachePoolProblem {
    public static void main(String[] args) {
        Integer a1 = 1;
        Integer b1 = 2;
        Integer c1 = 3;
        Integer d1 = 3;
        Integer e1 = 321;
        Integer f1 = 321;
        Long g1 = 3L;
        Long h1 = 2L;

        System.out.println(c1 == d1);  //true， 范围在-128~127缓存区内
        System.out.println(e1 == f1);  //false, 超出缓存区大小(-128~127), 会重新new Integer(321)
        System.out.println(c1 == (a1 + b1)); //true,操作数是表达式（即包含算术运算）则比较的是数值（即会触发自动拆箱的过程）
        System.out.println(c1.equals(a1 + b1)); //true
        System.out.println(g1 == (a1 + b1));//true, 类型提升
        System.out.println(g1.equals(a1 + b1)); //false, 不会除非类型提升
        System.out.println(g1.equals(a1 + h1)); //true, 类型提升


    }
}
