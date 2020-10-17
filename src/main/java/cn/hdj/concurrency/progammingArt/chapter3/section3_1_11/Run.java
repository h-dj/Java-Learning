package cn.hdj.concurrency.progammingArt.chapter3.section3_1_11;

/**
 * @author h_dj
 * @version V1.0
 * @Title: Run
 * @Package cn.hdj.concurrency.progammingArt.chapter3.section3_1_11
 * @Description: TODO
 * @date 2018/9/26 12:57
 */
public class Run {

    public static void main(String[] args) {
//        List<String> data = new ArrayList<>(100);
//        Producer producer = new Producer(data);
//        Consumer consumer = new Consumer(data);
//
//        producer.start();
//        consumer.start();

        MyStack myStack=new MyStack();

        ProducerThread p=new ProducerThread(myStack);
        ConsumerThread c=new ConsumerThread(myStack);
        ConsumerThread c1=new ConsumerThread(myStack);
        ConsumerThread c2=new ConsumerThread(myStack);
        ConsumerThread c3=new ConsumerThread(myStack);
        ConsumerThread c4=new ConsumerThread(myStack);

        p.start();
        c.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();

    }
}
