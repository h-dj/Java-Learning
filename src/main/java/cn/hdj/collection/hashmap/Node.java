package cn.hdj.collection.hashmap;

/**
 * @Auther: h_dj
 * @Date: 2019/4/15 12:01
 * @Description: hashmap 的结点
 */
public class Node<K, V> {
    //键
    public final K key;
    //值
    public V value;
    //指针
    public Node<K, V> next;

    Node(K key, V value, Node<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
