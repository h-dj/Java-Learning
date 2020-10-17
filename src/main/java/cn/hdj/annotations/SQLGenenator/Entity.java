package cn.hdj.annotations.SQLGenenator;

@DBTable(name = "MEMBER")
public class Entity {
    @SQLBoolean()
    boolean sex;
    @SQLString(30)
    String firstName;
    @SQLString(50)
    String lastName;
    @SQLInteger
    Integer age;
    @SQLString(value = 30, containts = @Containts(primaryKey = true))
    String handle;

    static int memberCount;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    public static int getMemberCount() {
        return memberCount;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", handle='" + handle + '\'' +
                '}';
    }
}
