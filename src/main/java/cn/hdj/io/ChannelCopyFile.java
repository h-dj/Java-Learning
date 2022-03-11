package cn.hdj.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author huangjiajian
 * @Date 2022/1/13 15:24
 */
public class ChannelCopyFile {

    public static void main(String[] args) throws IOException {
        //创建输入流
        FileInputStream input = new FileInputStream("./test.txt");
        //获取只读通道
        ReadableByteChannel source = input.getChannel();

        //创建输出流
        FileOutputStream output = new FileOutputStream("./test4.txt");
        //获取只能写入通道
        WritableByteChannel dest = output.getChannel();

        //创建直接缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(16 * 1024);

        while (source.read(buffer) != -1) {
            // 转换缓冲区为可读模式
            //即使用limit 变量指定可读区域（范围position < read < limit）
            buffer.flip();

            // 保证读取全部缓冲区中的元素
            while (buffer.hasRemaining()) {
                dest.write(buffer);
            }
            //标识缓冲区为空状态，表示可写入
            //position =0, limit=capacity
            //数据实际上并没有置空
            buffer.clear();
        }
        //关闭通道
        source.close();
        dest.close();
    }
}
