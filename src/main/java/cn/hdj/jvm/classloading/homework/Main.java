package cn.hdj.jvm.classloading.homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get("D:\\IDEA\\Java-Learning\\src\\main\\java\\cn\\hdj\\jvm\\classloading\\homework\\Hello.class"));
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        Files.write(Paths.get("D:\\IDEA\\Java-Learning\\src\\main\\java\\cn\\hdj\\jvm\\classloading\\homework\\Hello.xlass"),bytes);
    }
}
