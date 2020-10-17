package cn.hdj.annotations.ch1;

/**
 * @Auther: h_dj
 * @Date: 2019/5/14 17:15
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Person hdj = new PersonBuilder()
                .setAge(12)
                .setName("hdj")
                .build();


    }
}
