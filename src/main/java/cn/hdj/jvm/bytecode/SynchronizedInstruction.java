package cn.hdj.jvm.bytecode;

/**
 * @Description: 同步指令
 * @Author hdj
 * @Date 2021/3/20 下午5:00
 */
public class SynchronizedInstruction {
    private Object lock=new Object();
    void onlyMe(Object lock){
        synchronized (lock){
            //doSomething
        }
    }
}
