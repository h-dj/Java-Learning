package cn.hdj.jvm.bytecode;

/**
 * @Description: 类型转换指令
 * @Author hdj
 * @Date 2021/3/20 下午3:50
 */
public class TypeConverterInstruction {

    public static void main(String[] args) {
        double nan = 0.0 / 0.0;
        int a = (int) nan;
        System.out.println(a);

        float b = (float) nan;
        System.out.println(b);

        double c = Math.PI;
        System.out.println(c);

        int d = (int) c;

        System.out.println(d);

        float e = (float) c;
        System.out.println(e);
    }
}



