package cn.hdj.annotations.ch1;

/**
 * @Auther: h_dj
 * @Date: 2019/5/14 16:03
 * @Description:
 */
public class PersonBuilder {

    private Person object = new Person();

    public Person build() {
        return object;
    }

    public PersonBuilder setName(java.lang.String value) {
        object.setName(value);
        return this;
    }

    public PersonBuilder setAge(int value) {
        object.setAge(value);
        return this;
    }


}
