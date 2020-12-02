package cn.hdj.jvm.gc;

/**
 * JVM  args :-XX:+PrintGCDetails 通过此命令可以打印GC信息
 * 引用计数GC:
 */
public class ReferenceCountingGC {
    private Object instance=null;

    public static final int _1M=1024*1024;

    private byte[] bytes=new byte[2*_1M];

    public static void testGC(){
        ReferenceCountingGC rA = new ReferenceCountingGC();
        ReferenceCountingGC rB = new ReferenceCountingGC();

        rA.instance = rB;
        rB.instance = rA;

        rA=null;
        rB=null;


        //手动发生GC
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
