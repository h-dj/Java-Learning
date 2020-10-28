package cn.hdj.jvm.classloading;

import sun.misc.Launcher;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 显示当前加载器，加载那些jar包
 */
public class ClassLoaderTest {

    public static void main(String[] args) {

        //启动类加载器
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        System.out.println("启动类加载器=》");
        Arrays.stream(urLs).forEach(System.out::println);

        //扩展类加载器
        System.out.println("扩展类加载器=》");
        printClassLoader("扩展类加载器",ClassLoaderTest.class.getClassLoader().getParent());


        //应用类加载器
        System.out.println("应用类加载器=》");
        printClassLoader("应用类加载器",ClassLoaderTest.class.getClassLoader());
    }


    private static void printClassLoader(String name, ClassLoader classLoader) {
        if (classLoader != null) {
            System.out.println("ClassLoader => " + classLoader.toString());
            printURLForClassloader(classLoader);
        }

    }

    private static void printURLForClassloader(ClassLoader classLoader) {
        Object ucp = isSignField(classLoader, "ucp");
        Object path = isSignField(ucp, "path");
        ((ArrayList)path).forEach(System.out::println);
    }

    private static Object isSignField(Object classLoader, String name) {
        try {
            Field field = null;
            if (classLoader instanceof URLClassLoader) {
                field = URLClassLoader.class.getDeclaredField(name);
            } else {
                field = classLoader.getClass().getDeclaredField(name);
            }
            field.setAccessible(true);
            return field.get(classLoader);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
