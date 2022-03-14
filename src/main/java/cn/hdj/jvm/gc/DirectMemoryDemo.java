package cn.hdj.jvm.gc;

import java.nio.ByteBuffer;

/**
 * @Description: 直接内存  -XX:MaxDirectMemorySize=8m
 * @Author huangjiajian
 * @Date 2022/3/14 10:21
 */
public class DirectMemoryDemo {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(9 * 1024 * 1024);
    }
}
