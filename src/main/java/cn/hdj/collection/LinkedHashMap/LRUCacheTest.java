package cn.hdj.collection.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: LRU缓存实现
 * @Author huangjiajian
 * @Date 2021/6/13 下午8:35
 */
public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(16);
        cache.put(1, 2);
        cache.put(2, 3);
        cache.put(3, 4);
        cache.put(5, 6);

        cache.get(2);
        cache.get(5);

        cache.forEach((o, o2) -> {
            System.out.println(o2);
        });
    }
}

class LRUCache extends LinkedHashMap {
    private final int MAX_CACHE_SIZE;

    public LRUCache(int cacheSize) {
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        MAX_CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_CACHE_SIZE;
    }
}