package cn.hdj.command;

/**
 * @author h_dj
 * @version V1.0
 * @Title: JavapTest
 * @Package cn.hdj.command
 * @Description: TODO
 * @date 2018/9/10 9:46
 */
public class JavapTest {


    public static void main(String[] args) {

        double a = 0.1;
        double b = 3;
        System.out.println(a + b);
        System.out.println(a * b);
        System.out.println(a - b);
        System.out.println(a / b);

        int i = 1;
        int z = i++ + ++i + ++i + ++i + i++ + ++i;
        System.out.println(z);
    }
}
