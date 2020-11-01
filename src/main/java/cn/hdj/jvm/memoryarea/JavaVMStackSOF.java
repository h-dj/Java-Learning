package cn.hdj.jvm.memoryarea;

/**
 * VM arg:  -Xss128k
 *
 * 测试：如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出StackOverflowError异常
 */
public class JavaVMStackSOF {

    private int stackLlength = 0;

    private void stackLeak() {
        this.stackLlength++;
        this.stackLeak();
    }


    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF=new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("栈长度 "+ javaVMStackSOF.stackLlength);
            throw e;

        }
    }
}
