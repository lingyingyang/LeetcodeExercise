package concurrent.async;

import concurrent.async.jobs.HotWaterJob;
import concurrent.async.jobs.WashJob;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/** 或者可以用CompletableFuture或CountDownLatch来实现 => https://juejin.im/entry/5c1b6ae0f265da61715e4c96 */
@Slf4j
public class JavaFutureDemo {
  public static void main(String[] args) {
    Callable<Boolean> hJob = new HotWaterJob();
    FutureTask<Boolean> hTask = new FutureTask<>(hJob);
    Thread hThread = new Thread(hTask, "** 烧水-Thread");

    Callable<Boolean> wJob = new WashJob();
    FutureTask<Boolean> wTask = new FutureTask<>(wJob);
    Thread wThread = new Thread(wTask, "$$ 清洗-Thread");

    hThread.start();
    wThread.start();
    Thread.currentThread().setName("主线程");

    try {
      boolean cupOk = wTask.get();
      boolean waterOk = hTask.get();
      log.info("多线程取结果，get()会阻塞");
      drinkTea(waterOk, cupOk);
    } catch (InterruptedException e) {
      log.info(getCurThreadName() + "发生异常被中断.");
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    log.info(getCurThreadName() + " 运行结束.");
  }

  public static String getCurThreadName() {
    return Thread.currentThread().getName();
  }

  public static void drinkTea(boolean waterOk, boolean cupOk) {
    if (waterOk && cupOk) {
      log.info("泡茶喝");
    } else if (!waterOk) {
      log.info("烧水失败，没有茶喝了");
    } else if (!cupOk) {
      log.info("杯子洗不了，没有茶喝了");
    }
  }
}
