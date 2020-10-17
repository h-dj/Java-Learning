package cn.hdj.annotations.ch1;

/**
 * @Auther: h_dj
 * @Date: 2019/5/14 16:02
 * @Description:
 */
public class Person {
    private int age;

    private String name;

    public int getAge() {
        return age;
    }

    @BuilderProperty
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @BuilderProperty
    public void setName(String name) {
        this.name = name;
    }
}
