package cn.hdj.jvm.gc;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description: <p>
 * java8 -XX:MaxMetaspaceSize=20m
 * <p>
 * java7 -XX:MaxPermSize=8m
 * @Author huangjiajian
 * @Date 2022/3/14 10:14
 */
public class PermGenOOMDemo {

    /**
     * 使用 CGLib 不断创建class 信息到元空间
     *
     * @param args
     */
    public static void main(String[] args) {
        int i = 0;

        try {
            for (; ; ) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(PermGenOOMDemo.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o, args);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
