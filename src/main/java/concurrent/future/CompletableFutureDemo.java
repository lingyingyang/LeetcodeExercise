package concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(new AskThread(future)).start();
        //模拟长时间的计算过程
        Thread.sleep(2000);
        //告知完成结果
        future.complete(60);

        //另外一个例子
        final CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(
                () -> calculate(50)).exceptionally(
                ex -> {
                    ex.printStackTrace();
                    return 0;
                });
        final CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " start!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(future1.get());
        System.out.println(future2.get());
    }

    private static Integer calculate(Integer in) {
        //默认ForkJoinPool.commonPool来执行
        System.out.println(Thread.currentThread().getName() + " start!");
        //模拟长时间的计算过程
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return in * in;
    }

    public static class AskThread implements Runnable {
        private CompletableFuture<Integer> future;

        public AskThread(CompletableFuture<Integer> future) {
            this.future = future;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start!");
            int ans = 0;
            try {
                ans = future.get() * future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(ans);
        }
    }
}
