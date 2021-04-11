package cn.hdj.jvm.classloading;

/**
 * @Description:　`<clinit>()`同步执行耗时操作，导致线程阻塞
 * @Author huangjiajian
 * @Date 2021/4/11 下午2:21
 */
public class DeadLoopClassTest {

    static class DeadLoopClass{
        static {
            if (true) {
                System.out.println(Thread.currentThread() + "init DeadLoopClass");
                while (true) {
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass deadLoopClass=new DeadLoopClass();
                System.out.println(Thread.currentThread() + "run Over");
            }
        };

        Thread thread1=new Thread(runnable);
        Thread thread2=new Thread(runnable);

        thread1.start();
        thread2.start();
    }
}
