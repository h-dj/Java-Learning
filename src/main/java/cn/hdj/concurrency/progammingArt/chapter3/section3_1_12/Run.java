package cn.hdj.concurrency.progammingArt.chapter3.section3_1_12;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.TimeUnit;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Run
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_12
 * @Description: TODO
 * @date 2018/9/26 16:14
 */
public class Run {

    public static void main(String[] args) throws IOException, InterruptedException {
        ReadData readData = new ReadData();
        WriteData writeData = new WriteData();

        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream();

        pipedOutputStream.connect(pipedInputStream);

        ThreadRead threadRead = new ThreadRead(readData, pipedInputStream);

        ThreadWrite threadWrite = new ThreadWrite(writeData, pipedOutputStream);

        threadWrite.start();

        TimeUnit.SECONDS.sleep(5);
        threadRead.start();

    }
}
