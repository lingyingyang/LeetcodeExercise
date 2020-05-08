package concurrent.threadpool;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

public class ThreadPoolExtAndFactoryDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadFactory() {//可以自定义线程的创建
                    @Override
                    public Thread newThread(@NotNull Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        System.out.println("create " + t);
                        return t;
                    }
                }) {//扩展线程池的hook方法
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行：" + ((MyTask) r).name);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成：" + ((MyTask) r).name);
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };

        for (int i = 0; i < 5; i++) {
            MyTask task = new MyTask("Task-" + i);
            service.execute(task);
            Thread.sleep(10);
        }
        Thread.sleep(2000);//等所有task完成
        service.shutdown();
    }

    public static class MyTask implements Runnable {
        public String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.printf("正在执行 Thread ID: %s, Task Name: %s \n",
                    Thread.currentThread().getId(), Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
