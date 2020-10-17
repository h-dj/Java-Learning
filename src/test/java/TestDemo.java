import org.junit.Ignore;
import org.junit.Test;

/**
 * @Auther: h_dj
 * @Date: 2019/5/12 22:15
 * @Description:
 */
public class TestDemo {

    @Test
    public void testOperatorCast() {
        int a = 1;
        float b = 2f;
        // a = a + b; //不能编译成功，因为没有进行类型转换，如：a = (int) (a + b)
        a += b; //编译成功，因为隐式类型转换，相等于：a = (int) (a + b)
    }

    @Test
    public void testSwitch() {
        //char, byte, short, int, Character, Byte, Short, Integer, String, or an enum
//        switch (1L) {
//            default:
//                System.out.println(123);
//                break;
//        }
    }

    @Test
    public void testInterfaceAndAbstractClass() {
//        TestInterface.func();

        TestInterface testClass=new TestClass();
        testClass.func2();
        TestInterface.func();
    }


}

interface TestInterface {
  public  static int a = 2;

   public static void func() {
        System.out.println(123);
    }

    default void func2() {
        System.out.println("func2");
    }
}

class TestClass implements TestInterface{

}