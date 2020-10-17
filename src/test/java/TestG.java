import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: h_dj
 * @Date: 2019/5/13 12:10
 * @Description:
 */
public class TestG<T> {


    @Test

    public void test() {

        List<T> stringList = new ArrayList<>();
        for (T t : stringList) {
            System.out.println(t instanceof String);
        }
    }

}
