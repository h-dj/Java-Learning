package cn.hdj.collection;

import java.util.HashSet;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author huangjiajian
 * @Date 2022/2/28 9:19
 */
public class HashSetTest {

    public static void main(String[] args) {
        Student s = new Student();
        s.name = "java";
        s.num = "123456";

        HashSet hashSet = new HashSet();
        hashSet.add( s);
        System.out.println(hashSet.contains(s));

        //改变学号，计算hashcode 时也发生改变，所以可以存入hashset中
        s.num = "123";
        hashSet.add(s);
        //存入了两个元素
        System.out.println(hashSet.size());
    }
}
class Student {
    String num;
    String name;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        if (num != null ? !num.equals(student.num) : student.num != null) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }
    @Override
    public int hashCode() {
        int result = num != null ? num.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}