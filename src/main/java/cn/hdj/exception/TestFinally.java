package cn.hdj.exception;

/**
 * @author h_dj
 * @version V1.0
 * @Title: TestFinally
 * @Package cn.hdj.exception
 * @Description: 探讨finally执行状况
 * @date 2018/3/12 20:36
 */
public class TestFinally {


    public static void main(String[] args) {
        //  System.out.println(method());//4. 所以，结果时 1

        System.out.println(method2());//5. 所以，结果时 2
    }

    public static int method() {
        int x = 1;
        try {
            return x;
            //1. 当程序执行到这里时，就会先返回相应的值，
            // 并把相应的值存储在一个临时栈中去保存这个结果 x= 1； 但并不会立即返回值

            //3. 执行完finally语句后，会告诉主调程序，被调程序已经执行完了并把临时栈中的值返回，

        } catch (Exception e) {
            return 0;
        } finally {
            ++x; //2. 然后来执行finally语句 ，x = 2
        }
    }


    public static int method2() {
        int x = 1;
        try {
            return x;
            //1. 当程序执行到这里时，就会先返回相应的值，
            // 并把相应的值存储在一个临时栈中去保存这个结果 x= 1； 但并不会立即返回值

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            ++x; //2. 然后来执行finally语句 ，x = 2
            return x; //3. 把x值存储在一个临时栈中，覆盖原来临时栈中的值x=1
        }

        //4. 执行完finally语句后，会告诉主调程序，被调程序已经执行完了并把临时栈中的值返回，
    }
}
