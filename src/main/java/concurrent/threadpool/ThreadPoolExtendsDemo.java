package concurrent.threadpool;

import java.util.concurrent.*;

public class ThreadPoolExtendsDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor service = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        for (int i = 0; i < 5; i++) {
            //没有显示异常堆栈
//            service.submit(new DivTask(100, i));

            //显示部分异常堆栈
            //方法1
            Future<?> res = service.submit(new DivTask(100, i));
            res.get();
            //方法2
//            service.execute(new DivTask(100, i));
        }

        //显示全部的异常堆栈
        ThreadPoolExecutor serviceWithTrace = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        for (int i = 0; i < 5; i++) {
            serviceWithTrace.execute(new DivTask(100, i));
        }
    }

    public static class DivTask implements Runnable {
        private int a, b;

        public DivTask(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            double ans = a / b;
            System.out.println(ans);
        }
    }

    /**
     * 扩展ThreadPoolExecutor来实现异常堆栈的打印和追踪
     */
    public static class TraceThreadPoolExecutor extends ThreadPoolExecutor {

        public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                       TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        @Override
        public void execute(Runnable command) {
            super.execute(wrap(command, clientTrace(), Thread.currentThread().getName()));
        }

        private Runnable wrap(final Runnable command, final Exception clientTrace, String name) {
            return new Runnable() {
                @Override
                public void run() {
                    try {
                        command.run();
                    } catch (Exception e) {
                        clientTrace.printStackTrace();
                        throw e;
                    }
                }
            };
        }

        private Exception clientTrace() {
            return new Exception("Client stack trace");
        }
    }
}
