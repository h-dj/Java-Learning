package cn.hdj.jvm.memoryarea;

/**
 * VM arg:  -Xss2m
 *
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while (true) {
        }
    }

    private void stackLeakByThread(){
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程："+Thread.currentThread().getName());
                    dontStop();
                }
            });
            thread.start();
        }
    }




    public static void main(String[] args) {
            JavaVMStackOOM javaVMStackOOM=new JavaVMStackOOM();
            javaVMStackOOM.stackLeakByThread();
    }
}
