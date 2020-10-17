package cn.hdj.concurrency.progammingArt.chapter3.section3_1_12;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @author h_dj
 * @version V1.0
 * @Title: WriteData
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_12
 * @Description: TODO
 * @date 2018/9/26 15:39
 */
public class WriteData {

    public void writeDataMethod(PipedOutputStream pipedOutputStream) {


        try {
            System.out.println("write : ");
            for (int i = 0; i < 300; i++) {
                String data = " " + i;
                pipedOutputStream.write(data.getBytes());
                System.out.print(data);
            }

            System.out.println();
            pipedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
