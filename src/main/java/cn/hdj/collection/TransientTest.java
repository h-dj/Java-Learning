package cn.hdj.collection;

import java.io.*;

/**
 * @author h_dj
 * @version V1.0
 * @Title: TransientTest
 * @Package cn.hdj.collection
 * @Description: Transient 防止被序列化的关键字
 * @date 2017/11/1 20:22
 */
public class TransientTest {


    public static void main(String[] args) throws IOException {
        //// TODO: 2017/11/1
        Person person = new Person("张三", "123456");
        System.out.println("序列化前：" + person);
        //序列化保存
        ObjectOutputStream o = null;
        try {
            o = new ObjectOutputStream(new FileOutputStream(
                    "person.out"));
            o.writeObject(person);
            o.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //反序列读取
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.out"));
        try {
            Object object = objectInputStream.readObject();
            System.out.println("序列化后：" + object);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 序列化前：Person{name='张三', password='123456'}
 * 序列化后：Person{name='张三', password='null'}
 */
class Person implements Serializable {
    String name;
    transient String password;

    public Person(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}