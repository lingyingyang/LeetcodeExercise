package concurrent.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class MainClient {
    public static void main(String[] args) throws InterruptedException {
        //建立queue
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);
        ExecutorService executor = Executors.newCachedThreadPool();
        Consumer[] consumers = new Consumer[3];
        Producer[] producers = new Producer[3];
        //建立消费者
        for (int i = 0; i < 3; i++) {
            Consumer consumer = new Consumer(queue);
            consumers[i] = consumer;
            executor.execute(consumer);
        }
        //建立生产者
        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer(queue);
            producers[i] = producer;
            executor.execute(producer);
        }
        Thread.sleep(10000);
        for (Consumer consumer : consumers) {
            consumer.stop();
        }
        for (Producer producer : producers) {
            producer.stop();
        }
        executor.shutdown();
    }
}
