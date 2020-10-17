package cn.hdj.concurrency;

/**
 * @author h_dj
 * @version V1.0
 * @Title: App11_3
 * @Package cn.hdj.concurrency
 * @Description: TODO
 * @date 2018/3/17 21:46
 */
public class App11_3 {

    public static void main(String[] args) {
        //// TODO: 2018/3/17
        MyThread you = new MyThread("you");
        MyThread she = new MyThread("she");
        Thread thread1 = new Thread(you);
        Thread thread2 = new Thread(she);
        thread1.start();

        try {
            thread1.join(); //等待该线程终止。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
        try {
            thread2.join();//等待该线程终止。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主方法main运行结束");

        int x = 5, y = 7;
        boolean c = (x++ > 5) && (++y > 0);
        if (c) {
            System.out.println(x + " : " + y);
        }
        System.out.println(x + " " + y);
    }
}
