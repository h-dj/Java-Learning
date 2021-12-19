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

        MyHashMap myHashMap=new MyHashMap();
        myHashMap.put("1","1");
        myHashMap.put("2","2");
        myHashMap.put("3","3");
        myHashMap.put("4","4");
        myHashMap.put("5","5");


        myHashMap.remove("2");
        myHashMap.remove("2");
        myHashMap.remove("5");
        myHashMap.remove("1");
        myHashMap.put("1","6");

        for (int i = 1; i <= 5; i++) {
            System.out.println(myHashMap.get(""+i));
        }

    }
}
