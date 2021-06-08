package cn.hdj.collection.hashmap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author huangjiajian
 * @Date 2021/6/2 17:30
 */
public class MapTest {

    public static void main(String[] args) {

        Hashtable hashtable=new Hashtable();
        hashtable.put(null,"1");

        HashMap hashMap=new HashMap(16);
        hashMap.put(null,"1");


        Set set = hashMap.keySet();

        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap(16);
        concurrentHashMap.put(null,"1");

        LinkedHashMap linkedHashMap=new LinkedHashMap();
        linkedHashMap.put("a",123);
    }
}
