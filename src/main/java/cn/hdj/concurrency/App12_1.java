package cn.hdj.concurrency;

/**
 * @author h_dj
 * @version V1.0
 * @Title: App12_1
 * @Package cn.hdj.concurrency
 * @Description: TODO
 * @date 2018/3/17 22:34
 */
public class App12_1 {


    public static void main(String[] args) {
        int three = 3;
        char one = 'a';
        System.out.println((int)one);
        System.out.println((int)'b');
        char four = (char) (three + one);
        System.out.println(four);
        System.out.println((int)'0');
        System.out.println((int)'4');
        System.out.println((int)'Z');
    }
}
