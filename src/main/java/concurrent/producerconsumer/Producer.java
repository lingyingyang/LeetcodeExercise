package concurrent.producerconsumer;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Producer implements Runnable {
    private volatile boolean isRunning = true;
    private BlockingQueue<Integer> queue;
    //总数
    private static AtomicInteger count = new AtomicInteger();
    public static final int SLEEP_TIME = 1000;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random r = new Random();
        log.info("Start producer id: {}", Thread.currentThread().getId());
        try {
            while (isRunning) {
                Thread.sleep(r.nextInt(SLEEP_TIME));
                int idx = count.getAndIncrement();
                log.info("{} put into queue", idx);
                //提交数据到queue
                if (!queue.offer(idx, 2, TimeUnit.SECONDS)) {
                    log.error("Failed to put data: {}", idx);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        this.isRunning = false;
    }
}
