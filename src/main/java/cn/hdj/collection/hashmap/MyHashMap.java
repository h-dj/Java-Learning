package cn.hdj.collection.hashmap;

/**
 * @Auther: h_dj
 * @Date: 2019/4/15 11:30
 * @Description: 实现hashmap
 * <p>
 * <a>https://dzone.com/articles/custom-hashmap-implementation-in-java</a>
 */
public class MyHashMap<K, V> {

    //元素数组
    private Node<K, V>[] tables;
    //元素个数
    private int size;
    //数组的默认容量16
    private final static int DEFAULT_CAPACIRY = 1 << 4; //16
    //最大容量
    private final static int MAXIMUM_CAPACITY = 1 << 30; //2^30
    //容量
    private int capacity;

    /**
     * 构造函数
     */
    public MyHashMap() {
        this(DEFAULT_CAPACIRY);
    }

    public MyHashMap(int initCapacity) {
        this.size = 0;
        this.capacity = initCapacity;
        tables = new Node[initCapacity];
    }

    /**
     * 插入操作
     * 步骤：
     * 1. 对要存放的键值计算键的 散列码(hash code)，这散列码通常是一个整型(int)数值；
     * 因为可能有无穷个对象，但只有有限个整型(int)数值, 所以不同的对象可能有相同的散列码
     * <p>
     * 2.然后，使用键的散列码 通过求模 hashCode(key) % table.length 来计算对象存放在数组中的下标
     * 注意：这里，两个不同的 散列码 可能会映射到数组中相同的下标
     * <p>
     * 3. 获取通过步骤二计算出的下标得到的链表，保存对象到这个下标的链表中。
     * 这个链表的作用很重要，因为它解决了以下冲突：
     * -  不同的键肯能有相同的 散列码
     * -  不同的散列码 可能映射到相同的下标
     *
     * @return
     */
    public void put(K key, V value) {
        //创建结点
        Node<K, V> entry = new Node<>(key, value, null);
//        计算键的散列码(hash code)
        int hash = hash(key);
        //计算存放的下标
        int index = indexFor(hash, tables.length);

        //获取该下标下的链表
        //插入该链表
        Node<K, V> node = tables[index];
        if (node == null) {
            tables[index] = entry;
            size++;
        } else {
            //查找链表中是否已存在该元素的键
            while (node.next != null) {
                if (node.key.equals(key)) {
                    //存在则，更新值
                    node.value = value;
                    return;
                }
                node = node.next;
            }

            //当该链表只用一个元素时，判断键值是否相同
            //是则只更新值，长度不变
            if (node.key.equals(key)) {
                node.value = value;
            } else {
                //否则，插入链表的最后一个
                node.next = entry;
                //长度加一
                size++;
            }
        }
    }


    /**
     * 获取值
     * <p>
     * 步骤：
     * 1.
     *
     * @param key
     * @return
     */
    public V get(K key) {
        //计算键的散列码(hash code)
        int hash = hash(key);
        //计算存放的下标
        int index = indexFor(hash, tables.length);

        //获取该下标下的链表
        //在该链表下查找
        Node<K, V> node = tables[index];
        Node<K, V> get = null;
        while (node != null) {
            if (node.key.equals(key)) {
                get = node;
                break;
            }
            node = node.next;
        }
        return get.value;
    }

    private int hash(Object key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    private int indexFor(int hash, int length) {
        return hash % tables.length;
    }
}
