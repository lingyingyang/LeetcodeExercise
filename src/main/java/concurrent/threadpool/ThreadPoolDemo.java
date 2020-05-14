package concurrent.threadpool;

import lombok.AllArgsConstructor;
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
        MyTaskTimeOut taskTimeOut = new MyTaskTimeOut();
        //taskTimeOut#call被不同的线程同时调用
        tasks.add(taskTimeOut);
        tasks.add(taskTimeOut);
        tasks.add(taskTimeOut);

        List<Future<String>> futures = null;
        try {
            futures = executor.invokeAll(tasks, 2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        if (futures != null) {
            for (Future<String> future : futures) {
                if (future.isCancelled()) {
                    log.info("{} isCancelled => {}, then can do something to handle the timeout exception",
                            future.toString(), future.isCancelled());
                }
            }
        }
    }

    static class MyTaskTimeOut implements Callable<String> {

        @Override
        public String call() throws Exception {
            log.info("MyTaskTimeOut begin: {}", Thread.currentThread().getName());
            Thread.sleep(5000);//所有MyTaskTimeOut都会超时被丢弃
            log.info("MyTaskTimeOut end");
            return "Finish";
        }
    }

    @AllArgsConstructor
    static class MyTask implements Callable<String> {
        private int amt;

        @Override
        public String call() {
            log.info("MyTask{}", amt);
            return "Finish";
        }
    }
}
