package cn.hdj.concurrency.progammingArt.chapter3.section3_1_12;

import java.io.PipedInputStream;

/**
 * @author h_dj
 * @version V1.0
 * @Title: ThreadRead
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_12
 * @Description: TODO
 * @date 2018/9/26 16:12
 */
public class ThreadRead extends Thread {


    private ReadData readData;
    private PipedInputStream pipedInputStream;

    public ThreadRead(ReadData readData, PipedInputStream pipedInputStream) {
        this.readData = readData;
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        super.run();
        readData.readDataMethod(pipedInputStream);
    }
}
