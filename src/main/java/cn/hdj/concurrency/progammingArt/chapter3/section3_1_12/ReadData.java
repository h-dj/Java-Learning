package cn.hdj.concurrency.progammingArt.chapter3.section3_1_12;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author h_dj
 * @version V1.0
 * @Title: WriteData
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_12
 * @Description: TODO
 * @date 2018/9/26 15:39
 */
public class ReadData {

    public void readDataMethod(PipedInputStream pipedInputStream) {


        try {
            System.out.println("read  : ");

            byte[] buffer = new byte[1024];
            int readLength = pipedInputStream.read(buffer);
            while (readLength != -1) {
                String readData = new String(buffer);
                System.out.print(readData);
                readLength = pipedInputStream.read(buffer);
            }

            System.out.println();
            pipedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
