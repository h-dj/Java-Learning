package cn.hdj.jvm.reference;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @Description: Java 四种引用:
 * @Author hdj
 * @Date 2020/12/12 下午3:58
 */
public class ReferenceTest {

    private static final int M = 1024*1024;
    //打印内存
    public static void printlnMemory(String tag) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("\n" + tag + ":");
        System.out.println(runtime.freeMemory() / M + "M(free)/" + runtime.totalMemory() / M + "M(total)");
    }

    /**
     * 测试强引用
     */
    @Test
    public void testStrongReference(){
        //先打印可用内存
        printlnMemory("1. 原来可用内存");
        //创建10M强引用的字节数组
        //实例化10M的数组并与strongReference建立强引用
        byte[] strongReference = new byte[10 * M];
        //手动触发gc
        System.gc();
        //再打印可用内存
        printlnMemory("1. 分配10M后，手动调用gc，可用内存");

        //断开引用
        strongReference = null;
        //手动触发gc
        System.gc();
        printlnMemory("1. 断开引用后,在调用gc，可用内存");
    }

    /**
     * 测试强引用
     */
    @Test
    public void testWeakReference(){
        //先打印可用内存
        printlnMemory("1. 原来可用内存");

        //创建弱引用
        WeakReference<Object> byteWeakReference = new WeakReference<>(new byte[10 * M]);

        printlnMemory("2. 分配10M 弱引用字节数组,可用内存");
        System.out.println("weakRerference.get() : " + byteWeakReference.get());


        //gc后可用内存
        System.gc();
        printlnMemory("3. gc后,可用内存");
        System.out.println("weakRerference.get() : " + byteWeakReference.get());
    }


    /**
     * 限制堆大小: -Xmx20m -Xms20m
     */
    @Test
    public void testSoftReference(){
        //先打印可用内存
        printlnMemory("1. 原来可用内存");

        //创建弱引用
        SoftReference<Object> softReference = new SoftReference<>(new byte[10 * M]);

        printlnMemory("2.实例化10M的数组,并建立软引用");
        System.out.println("SoftReference.get() : " + softReference.get());


        //gc后可用内存
        System.gc();
        printlnMemory("3.内存可用容量充足，GC后");
        System.out.println("SoftReference.get() : " + softReference.get());


        //实例化一个10M的数组,使内存不够用,并建立软引用
        SoftReference<Object> softRerference2 = new SoftReference<Object>(new byte[10 * M]);
        printlnMemory("4.实例化一个10M的数组后");
        System.out.println("softRerference.get() : " + softReference.get());
        System.out.println("softRerference2.get() : " + softRerference2.get());
    }

    @Test
    public void testPhantomReference(){
        printlnMemory("1.原可用内存和总内存");
        byte[] object = new byte[10 * M];
        printlnMemory("2.实例化10M的数组后");

        //建立虚引用
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<Object>();
        PhantomReference<Object> phantomReference = new PhantomReference<Object>(object, referenceQueue);

        printlnMemory("3.建立虚引用后");
        System.out.println("phantomReference : " + phantomReference);
        System.out.println("phantomReference.get() : " + phantomReference.get());
        System.out.println("referenceQueue.poll() : " + referenceQueue.poll());

        //断开byte[10*M]的强引用
        object = null;
        printlnMemory("4.执行object = null;强引用断开后");

        System.gc();
        printlnMemory("5.GC后");
        System.out.println("phantomReference : " + phantomReference);
        System.out.println("phantomReference.get() : " + phantomReference.get());
        System.out.println("referenceQueue.poll() : " + referenceQueue.poll());

        //断开虚引用
        phantomReference = null;
        System.gc();
        printlnMemory("6.断开虚引用后GC");
        System.out.println("phantomReference : " + phantomReference);
        System.out.println("referenceQueue.poll() : " + referenceQueue.poll());
    }
}
