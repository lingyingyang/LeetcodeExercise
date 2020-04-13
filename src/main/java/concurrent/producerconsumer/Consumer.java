package concurrent.producerconsumer;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

@Slf4j
public class Consumer implements Runnable {
    private volatile boolean isRunning = true;
    private BlockingQueue<Integer> queue;
    public static final int SLEEP_TIME = 1000;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        log.info("Start consumer id: {}", Thread.currentThread().getId());
        Random r = new Random();
        try {
            while (isRunning) {
                Integer value = queue.take();
                int result = value * value;
                log.info("{} * {} = {}", value, value, result);
                Thread.sleep(r.nextInt(SLEEP_TIME));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        this.isRunning = false;
    }
}
