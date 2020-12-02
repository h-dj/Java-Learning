package cn.hdj.jvm.memoryarea;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法区OOM  -XX:MaxMetaspaceSize=12m
 *
 * -XX:MetaspaceSize 元空间初始值大小
 * -XX:MaxMetaspaceSize 元空间最大值大小，默认值为-1，不限制大小
 * -XX:MinMetaspaceFreeRatio  作用是在垃圾收集之后控制最小的元空间剩余容量的百分比，可减少因为元空间不足导致的垃圾收集的频率
 *
 *
 * 注意：
 * 1. 在经常运行时生成大量动态类的应用场景里，就应该特别关注这些类的回收状况，防止方法区OOM
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer=new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false); //不使用缓存
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,objects);
                }
            });
            enhancer.create();
        }

    }

    static class OOMObject{}
}
