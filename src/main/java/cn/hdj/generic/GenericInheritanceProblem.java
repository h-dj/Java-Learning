package cn.hdj.generic;

import java.util.List;

/**
 * @Description: 泛型继承赋值问题  extends\super
 * @Author huangjiajian
 * @Date 2021/6/12 下午2:48
 */
public class GenericInheritanceProblem {

    public static void main(String[] args) {
        List<A> a = null;
        List list;
        list = a;   //A对，因为List就是List<?>，代表最大的范围，A只是其中的一个点，肯定被包含在内
        List<B> b = null;
        //a = b;      //B错，点之间不能相互赋值
        List<?> qm;
        List<Object> o = null;
        qm = o;     //C对，List<?>代表最大的范围，List<Object>只是一个点，肯定被包含在内
        List<D> d = null;
        List<? extends B> downB;
        downB = d;  //D对，List<? extends B>代表小于等于B的范围，List<D>是一个点，在其中
        List<? extends A> downA = null;
        // a = downA;  //E错，范围不能赋值给点
        //a = o;      //F错，List<Object>只是一个点
        downA = downB;  //G对，小于等于A的范围包含小于等于B的范围，因为B本来就比A小，B时A的子类嘛
    }
}

class A {
}

class B extends A {
}

class C extends A {
}

class D extends B {
}
