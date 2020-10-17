package cn.hdj.concurrency.progammingArt.chapter2.section2_2_7;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Service2_2_7
 * @Package cn.hdj.concurrency.progammingArt.chapter2
 * @Description: 使用属性作为同步锁
 * @date 2018/9/19 17:27
 */
public class Service2_2_7 {

    private String name;
    private String password;

    private String anyString = new String();

    public   void setUsernameAndPassword(String name,String password){

        System.out.println(Thread.currentThread().getName()+"  "+System.currentTimeMillis()+"enter setUsernameAndPassword");
        synchronized (anyString){
            this.name = name;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.password = password;

            System.out.println(Thread.currentThread().getName()+"  "+System.currentTimeMillis()+"leave setUsernameAndPassword");

        }
    }

    public void method2(){
        synchronized (this){

            System.out.println(Thread.currentThread().getName()+"  "+System.currentTimeMillis()+"enter method2");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"  "+System.currentTimeMillis()+"leave method2");
        }
    }

    public void method1(){
        synchronized (anyString){

            System.out.println(Thread.currentThread().getName()+"  "+System.currentTimeMillis()+"enter method2");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"  "+System.currentTimeMillis()+"leave method2");
        }
    }

}