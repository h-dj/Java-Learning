package cn.hdj.collection.LinkedHashMap;

import org.junit.Test;

import java.util.LinkedHashMap;

/**
 * @author hdj
 * @version 1.0
 * @date 2019/10/7 22:08
 * @description:
 */
public class LinkedHashMapTest {


    @Test
    public void testInsertOrder() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();

        linkedHashMap.put(1, 2);
        linkedHashMap.put(2, 3);
        linkedHashMap.put(3, 4);
        linkedHashMap.put(5, 6);

        linkedHashMap.forEach((key, value) -> {
            System.out.println("Key:" + key + ", Value:" + value);
        });
    }


    @Test
    public void testAccessOrder() {
        //需要修改linkedHashMap中的排序方式，则要修改字段accessOrder 为true ,默认为false,即插入排序
        //true 为访问排序，
        LinkedHashMap linkedHashMap = new LinkedHashMap<>(2, .75f, true);

        linkedHashMap.put(1, 2);
        linkedHashMap.put(1, 3);
        linkedHashMap.put(2, 3);
        linkedHashMap.put(3, 4);
        linkedHashMap.put(5, 6);

        //以下方法都会触发afterNodeAccess 方法，把元素移到双向链表的尾部
        // put, putIfAbsent, get, getOrDefault, compute, computeIfAbsent, computeIfPresent, or merge
        // 方法执行，都会把元素放到链表的末端，这样就保证了插入的有序性
        linkedHashMap.get(2);
        linkedHashMap.get(5);
        linkedHashMap.get(1);

        linkedHashMap.forEach((key, value) -> {
            System.out.println("Key:" + key + ", Value:" + value);
        });
    }


}
