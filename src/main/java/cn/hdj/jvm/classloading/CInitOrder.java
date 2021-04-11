package cn.hdj.jvm.classloading;

/**
 * @Description:　初始化位置问题
 * @Author huangjiajian
 * @Date 2021/4/11 下午2:21
 */
public class CInitOrder {
    static {
        i = 0; //可以赋值
        //System.out.println(i); //放开注释，编译器，提示　Illegal forward reference　(非法向前引用)
    }

    //定义在静态代码块后的静态变量
    static int i = 1;

}
