package concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class ThreadPoolDemo {
    public static void main(String[] args) {
        AtomicInteger amt = new AtomicInteger(1);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                4, 4, 1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new ThreadPoolExecutor.DiscardPolicy());

        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
//            tasks.add(() -> {
//                log.info("MyTask{}", amt.getAndIncrement());
//                return "Finish";
//            });
            tasks.add(new MyTask(amt.getAndIncrement()));
        }
        tasks.add(new MyTaskTimeOut());

        List<Future<String>> futures = null;
        try {
            futures = executor.invokeAll(
                    tasks, 2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        if (futures != null) {
            for (Future<String> future : futures) {
                log.info("{} isCancelled => {}", future.toString(), future.isCancelled());
            }
        }
    }

    static class MyTaskTimeOut implements Callable<String> {

        public String call() throws Exception {
            log.info("MyTaskTimeOut begin");
            Thread.sleep(5000);
            log.info("MyTaskTimeOut end");
            return "Finish";
        }
    }

    static class MyTask implements Callable<String> {
        private int amt;

        public MyTask(int amt) {
            this.amt = amt;
        }

        public String call() {
            log.info("MyTask{}", amt);
            return "Finish";
        }
    }
}
