package cn.hdj.jvm.gc;

/**
 * @author huangjiajian
 * @date 2020/12/2
 */
public class CanReliveObj {
    public static CanReliveObj obj;

    /**
     *只会调用一次
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize() obj");
        //复活对象
        obj = this;
    }

    public static void main(String[] args) throws InterruptedException {

        obj = new CanReliveObj();
        obj = null;

        System.gc();

        Thread.sleep(1000);

        if (obj == null) {
            System.out.println("obj is null");
        }else{
            System.out.println("obj 可用");
        }

        System.out.println("第二次GC");

        System.gc();

        Thread.sleep(1000);

        if (obj == null) {
            System.out.println("obj is null");
        }else{
            System.out.println("obj 可用");
        }
    }
}
