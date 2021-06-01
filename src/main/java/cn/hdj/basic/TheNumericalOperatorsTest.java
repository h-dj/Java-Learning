package cn.hdj.basic;

/**
 * @Description: 类型提升测试
 * @Author huangjiajian
 * @Date 2021/6/1 17:15
 * <p>
 * 所有无final修饰的byte、short、char类型的值在作运算时（运行期），会被默认转换成int类型
 * https://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html#jls-5.6
 * <p>
 * 一元数字提升:
 * 如果操作数是编译时类型Byte、Short、 Character、 或Integer，则它会进行拆箱转换（第5.1.8 节）。然后int通过扩展原始转换（第5.1.2 节）或身份转换（第5.1.1 节）将结果提升为类型值。
 * 否则，如果操作数是编译时类型Long, Float, 或Double，则它会进行拆箱转换（第5.1.8 节）。
 * 否则，如果操作数是编译时类型byte、short或char，则int通过扩展原始转换（第5.1.2 节）将其提升为类型值。
 * 否则，一元数值操作数保持原样，不会被转换。
 * <p>
 * 二进制数字提升:
 * 如果任一操作数为 类型double，则另一个将转换为double.
 * 否则，如果任一操作数的类型为float，则另一个将转换为float。
 * 否则，如果任一操作数的类型为long，则另一个将转换为long。
 * 否则，两个操作数都被转换为 type int。
 */
public class TheNumericalOperatorsTest {

    public static void main(String[] args) {

        byte b1 = 1, b2 = 2, b3, b6;
        final byte b4 = 4, b5 = 6;

        b6 = b4 + b5;
        b3 = (byte) (b1 + b2); //不能自动转型
        System.out.println(b3 + b6);


        int c1 = 1, c2 = 2, c3;
        long c4 = 4L, c5 = 5L;

        c3 = (int) (c4 + c1);  //有long 类型，则将另一个转为long类型

    }
}
