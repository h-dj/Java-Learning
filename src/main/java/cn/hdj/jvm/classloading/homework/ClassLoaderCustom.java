package cn.hdj.jvm.classloading.homework;

import cn.hdj.jvm.bytecode.homework.Hello;
import sun.misc.Launcher;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 自定义类加载器，加载class文件
 */
public class ClassLoaderCustom {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    byte[] bytes = Files.readAllBytes(Paths.get("D:\\IDEA\\Java-Learning\\src\\main\\java\\cn\\hdj\\jvm\\classloading\\homework\\Hello.xlass"));
                    for (int i = 0; i < bytes.length; i++) {
                        bytes[i] = (byte) (255 - bytes[i]);
                    }
                    return this.defineClass(name, bytes, 0, bytes.length);
                } catch (Exception e) {
                    return super.loadClass(name);
                }
            }
        };


        Object newInstance = classLoader.loadClass("Hello").newInstance();
        System.out.println(newInstance.getClass());
        System.out.println(newInstance instanceof Hello);

        //执行方法
        Method method = newInstance.getClass().getDeclaredMethod("hello");
        method.setAccessible(true);
        method.invoke(newInstance);

    }
}
