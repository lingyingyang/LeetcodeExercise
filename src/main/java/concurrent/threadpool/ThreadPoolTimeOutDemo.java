package concurrent.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class ThreadPoolTimeOutDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<String>> futures = new ArrayList<>();
        futures.add(executor.submit(new MyTask(1)));
        futures.add(executor.submit(new MyTask(2)));
        futures.add(executor.submit(new MyTask(3)));
        MyTaskTimeOut taskTimeOut = new MyTaskTimeOut();
        futures.add(executor.submit(taskTimeOut));
        futures.add(executor.submit(taskTimeOut));
        futures.add(executor.submit(taskTimeOut));

        for (Future<String> future : futures) {
            try {
                future.get(2, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                // could have replied some default value
            } catch (TimeoutException e) {
                e.printStackTrace();
                future.cancel(true);
                log.error("Time out, then cancel that thread");
            }
        }
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);
    }

    static class MyTaskTimeOut implements Callable<String> {

        public String call() throws Exception {
            log.info("MyTaskTimeOut begin");
            Thread.sleep(5000);//所有MyTaskTimeOut都会超时被丢弃
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
