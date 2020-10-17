import org.junit.Test;

/**
 * @Auther: h_dj
 * @Date: 2019/5/12 22:59
 * @Description:
 */
public class TestSuper {

    @Test
    public void test1() {
        Zi zi=new Zi();
        zi.func1();

    }
}

class Fu {
    protected void func() {
        System.out.println("Fu.func");
    }
}

class Zi extends Fu {
    public void func1() {
        System.out.println(super.getClass().getName());
    }
}