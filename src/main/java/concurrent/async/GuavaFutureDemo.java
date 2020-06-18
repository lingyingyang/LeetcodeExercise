package concurrent.async;

import com.google.common.util.concurrent.*;
import concurrent.async.jobs.HotWaterJob;
import concurrent.async.jobs.WashJob;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 主线程不会阻塞
 */
@Slf4j
public class GuavaFutureDemo {

    public static final int SLEEP_GAP = 500;

    public static String getCurThreadName() {
        return Thread.currentThread().getName();
    }

    public static void main(String args[]) {

        //新起一个线程，作为泡茶主线程
        MainJob mainJob = new MainJob();
        Thread mainThread = new Thread(mainJob);
        mainThread.setName("主线程");
        mainThread.start();

        //烧水的业务逻辑
        Callable<Boolean> hotJob = new HotWaterJob();
        //清洗的业务逻辑
        Callable<Boolean> washJob = new WashJob();

        //创建java 线程池
        ExecutorService jPool =
                Executors.newFixedThreadPool(10);

        //包装java线程池，构造guava 线程池
        ListeningExecutorService gPool =
                MoreExecutors.listeningDecorator(jPool);

        //提交烧水的业务逻辑，取到异步任务
        ListenableFuture<Boolean> hotFuture = gPool.submit(hotJob);
        //绑定任务执行完成后的回调，到异步任务
        Futures.addCallback(hotFuture, new FutureCallback<Boolean>() {
            public void onSuccess(Boolean r) {
                if (r) {
                    mainJob.waterOk = true;
                }
            }

            public void onFailure(Throwable t) {
                log.info("烧水失败，没有茶喝了");
            }
        }, gPool);
        //提交清洗的业务逻辑，取到异步任务

        ListenableFuture<Boolean> washFuture = gPool.submit(washJob);
        //绑定任务执行完成后的回调，到异步任务
        Futures.addCallback(washFuture, new FutureCallback<Boolean>() {
            public void onSuccess(Boolean r) {
                if (r) {
                    mainJob.cupOk = true;
                }
            }

            public void onFailure(Throwable t) {
                log.info("杯子洗不了，没有茶喝了");
            }
        }, gPool);

        System.out.println(mainThread.getName() + "退出了===================");
    }

    //泡茶线程
    static class MainJob implements Runnable {
        boolean waterOk = false;
        boolean cupOk = false;
        int gap = SLEEP_GAP / 10;

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(gap);
                    log.info("读书中......");
                } catch (InterruptedException e) {
                    log.info(getCurThreadName() + "发生异常被中断.");
                }

                if (waterOk && cupOk) {
                    drinkTea(waterOk, cupOk);
                }
            }
        }

        public void drinkTea(Boolean wOk, Boolean cOK) {
            if (wOk && cOK) {
                log.info("泡茶喝，茶喝完");
                this.waterOk = false;
                this.gap = SLEEP_GAP * 100;
            } else if (!wOk) {
                log.info("烧水失败，没有茶喝了");
            } else if (!cOK) {
                log.info("杯子洗不了，没有茶喝了");
            }

        }
    }
}