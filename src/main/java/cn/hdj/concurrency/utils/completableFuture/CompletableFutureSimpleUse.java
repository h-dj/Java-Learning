package cn.hdj.concurrency.utils.completableFuture;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description: CompletableFuture 的简单使用
 * @Author huangjiajian
 * @Date 2021/4/22 16:06
 */
public class CompletableFutureSimpleUse {

    /**
     * CompletableFuture 作为future使用
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test_as_simple_future() throws ExecutionException, InterruptedException {
        //创建计算CompletableFuture
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        //使用线程池异步执行
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        //获取返回值
        Assert.assertEquals("Hello", completableFuture.get());
    }

    /**
     * CompletableFuture 可以使用lambda 组合逻辑
     */
    @Test
    public void test_encapsulated_computation_logic() throws ExecutionException, InterruptedException {

        //使用 Supplier ，获取返回值
        CompletableFuture<String> future
                = CompletableFuture.supplyAsync(() -> "Hello");

        Assert.assertEquals("Hello", future.get());

    }


    /**
     * 合并多个 CompletableFuture 操作
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test_combining_futures() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello")
                //组合CompletableFuture， 将上一个计算结果传递个下一个CompletableFuture
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
        //并行执行任务，不处理结果
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture
                = CompletableFuture.allOf(future1, future2, future3);

        Assert.assertEquals(null, combinedFuture.get());

        //并行处理，处理返回结果，使用join
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
