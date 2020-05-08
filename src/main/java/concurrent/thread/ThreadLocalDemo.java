package concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.*;

@Slf4j
public class ThreadLocalDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Long>[] futures = new Future[THREAD_AMT];
        for (int i = 0; i < THREAD_AMT; i++) {
            futures[i] = executor.submit(new RandomTask(0));
        }
        long time = 0;
        for (int i = 0; i < THREAD_AMT; i++) {
            time += futures[i].get();
        }
        log.info("多线程访问同一个Random实例耗时：{}ms", time);

        //ThreadLocal的情况
        for (int i = 0; i < THREAD_AMT; i++) {
            futures[i] = executor.submit(new RandomTask(1));
        }
        time = 0;
        for (int i = 0; i < THREAD_AMT; i++) {
            time += futures[i].get();
        }
        log.info("使用ThreadLocal包装Random实例耗时：{}ms", time);
        executor.shutdown();
    }

    public static final int GEN_COUNT = 10000000;
    public static final int THREAD_AMT = 4;
    public static Random random = new Random(123);
    public static ThreadLocal<Random> randomThreadLocal = ThreadLocal.withInitial(() -> new Random(123));
    static ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMT);

    public static class RandomTask implements Callable<Long> {
        private final int mode;

        public RandomTask(int mode) {
            this.mode = mode;
        }

        @Override
        public Long call() {
            long begin = System.currentTimeMillis();
            for (int i = 0; i < GEN_COUNT; i++) {
                getRandom().nextInt();
            }
            long end = System.currentTimeMillis();
            long timeCost = end - begin;
            log.info("{} spend {}ms", Thread.currentThread().getName(), timeCost);
            return timeCost;
        }

        private Random getRandom() {
            if (mode == 0) {
                return random;
            } else {
                return randomThreadLocal.get();
            }
        }
    }
}
