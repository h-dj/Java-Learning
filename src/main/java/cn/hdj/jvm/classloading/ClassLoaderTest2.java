package cn.hdj.jvm.classloading;

import java.io.InputStream;

/**
 * @Description:　不同类加载器加载相同的类
 * @Author huangjiajian
 * @Date 2021/4/11 下午2:21
 */
public class ClassLoaderTest2 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf('.') + 1) + ".class";
                    InputStream inputStream = this.getClass().getResourceAsStream(fileName);
                    if (inputStream == null) {
                        return super.loadClass(name);
                    }
                    byte[] buffer = new byte[inputStream.available()];
                    inputStream.read(buffer, 0, buffer.length);
                    return this.defineClass(name, buffer, 0, buffer.length);
                } catch (Exception e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object o = classLoader.loadClass("cn.hdj.jvm.classloading.ClassLoaderTest2").newInstance();
        System.out.println(o.getClass());
        System.out.println(o instanceof cn.hdj.jvm.classloading.ClassLoaderTest2);
    }
}
