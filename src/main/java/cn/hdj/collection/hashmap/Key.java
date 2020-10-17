package cn.hdj.collection.hashmap;

/**
 * @Auther: h_dj
 * @Date: 2019/4/15 16:52
 * @Description: 用于生成key, 测试用
 */
public class Key implements Comparable<Key> {

    private final int value;

    Key(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Key o) {
        return Integer.compare(this.value, o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Key key = (Key) o;
        return value == key.value;
    }

    @Override
    public int hashCode() {
//        return 1;
        return value;
    }
}