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
 * 如果操作数是编译时类型Byte、Short、 Character、 或Integer，则它会进行拆箱转换。然后int通过扩展原始转换或类型转换将结果提升为类型值。
 * 否则，如果操作数是编译时类型Long, Float, 或Double，则它会进行拆箱转换。
 * 否则，如果操作数是编译时类型byte、short或char，则int通过扩展原始转换将其提升为类型值。
 * 否则，一元数值操作数保持原样，不会被转换。
 * <p>
 * 二进制数字提升:
 * 如果任一操作数为 类型double，则另一个将转换为double.
 * 否则，如果任一操作数的类型为float，则另一个将转换为float。
 * 否则，如果任一操作数的类型为long，则另一个将转换为long。
 * 否则，两个操作数都被转换为 type int。
 */
public class TypePromotionProblem {

    public static void main(String[] args) {

        byte b1 = 1, b2 = 2, b3, b6;
        final byte b4 = 4, b5 = 6;

        b6 = b4 + b5;  // b4，b5由final 修饰，不会转换为int类型
       // b3 =(b1 + b2); //当表达式的操作数不是double，float，long时，两个操作数都转换为 int 类型，  b3 =  (byte)(b1 + b2)

    }
}
