package cn.hdj.concurrency.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description: CompletableFuture �ļ�ʹ��
 * @Author huangjiajian
 * @Date 2021/4/22 16:06
 */
public class CompletableFutureSimpleUse {

    /**
     * CompletableFuture ��Ϊfutureʹ��
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test_as_simple_future() throws ExecutionException, InterruptedException {
        //��������CompletableFuture
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        //ʹ���̳߳��첽ִ��
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        //��ȡ����ֵ
        Assert.assertEquals("Hello", completableFuture.get());
    }

    /**
     * CompletableFuture ����ʹ��lambda ����߼�
     */
    @Test
    public void test_encapsulated_computation_logic() throws ExecutionException, InterruptedException {

        //ʹ�� Supplier ����ȡ����ֵ
        CompletableFuture<String> future
                = CompletableFuture.supplyAsync(() -> "Hello");

        Assert.assertEquals("Hello", future.get());

    }


    /**
     * �ϲ���� CompletableFuture ����
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test_combining_futures() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello")
                //���CompletableFuture�� ����һ�����������ݸ���һ��CompletableFuture
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
        Assert.assertEquals("Hello World", completableFuture.get());


        CompletableFuture<String> completableFuture2
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(CompletableFuture.supplyAsync(
                        () -> " World"), (s1, s2) -> s1 + s2);

        Assert.assertEquals("Hello World", completableFuture2.get());
    }


    @Test
    public void test_parallelism_task() throws ExecutionException, InterruptedException {
        //����ִ�����񣬲�������
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture
                = CompletableFuture.allOf(future1, future2, future3);

        Assert.assertEquals(null, combinedFuture.get());

        //���д��������ؽ����ʹ��join
        CompletableFuture<String> future4
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future5
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future6
                = CompletableFuture.supplyAsync(() -> "World");

        String combined = Stream.of(future4, future5, future6)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        Assert.assertEquals("Hello Beautiful World", combined);
    }


    @Test
    public void test_handler_error() throws ExecutionException, InterruptedException {
        String name = null;

        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");

        Assert.assertEquals("Hello, Stranger!", completableFuture.get());
    }
}
