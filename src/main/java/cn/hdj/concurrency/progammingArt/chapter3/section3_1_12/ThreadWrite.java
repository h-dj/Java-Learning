package cn.hdj.concurrency.progammingArt.chapter3.section3_1_12;

import java.io.PipedOutputStream;

/**
 * @author h_dj
 * @version V1.0
 * @Title: ThreadRead
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_12
 * @Description: TODO
 * @date 2018/9/26 16:12
 */
public class ThreadWrite extends Thread {


    private WriteData writeData;
    private PipedOutputStream pipedOutputStream;

    public ThreadWrite(WriteData writeData, PipedOutputStream pipedOutputStream) {
        this.writeData = writeData;
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        super.run();
        writeData.writeDataMethod(pipedOutputStream);
    }
}
