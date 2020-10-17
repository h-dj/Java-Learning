package cn.hdj.annotations.processor;

import cn.hdj.annotations.processor.annotation.Id;
import cn.hdj.annotations.processor.annotation.Persistent;
import cn.hdj.annotations.processor.annotation.Property;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Person
 * @Package test
 * @Description: TODO
 * @date 2017/11/13 20:41
 */
@Persistent(table = "Person")
public class Person {
    @Id(column = "person_id", type = "integer", generator = "identity")
    private int id;
    @Property(column = "person_name", type = "string")
    private String name;
    @Property(column = "person_age", type = "integer")
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
