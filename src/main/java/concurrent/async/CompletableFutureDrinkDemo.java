package concurrent.async;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

@Slf4j
public class CompletableFutureDrinkDemo {
  public static void main(String[] args) {
    // 烧水的业务逻辑
    Supplier<Boolean> hotJob =
        () -> {
          try {
            log.info("洗好水壶");
            log.info("灌上凉水");
            log.info("放在火上");

            // 线程睡眠一段时间，代表烧水中
            Thread.sleep(1000);
            log.info("水开了");

          } catch (InterruptedException e) {
            log.info(" 发生异常被中断.");
            return false;
          }
          log.info(" 运行结束.");

          return true;
        };
    // 清洗的业务逻辑
    Supplier<Boolean> washJob =
        () -> {
          try {
            log.info("洗茶壶");
            log.info("洗茶杯");
            log.info("拿茶叶");
            // 线程睡眠一段时间，代表清洗中
            Thread.sleep(2000);
            log.info("洗完了");

          } catch (InterruptedException e) {
            log.info(" 清洗工作 发生异常被中断.");
            return false;
          }
          log.info(" 清洗工作  运行结束.");
          return true;
        };

    // 创建java 线程池
    ExecutorService jPool = Executors.newFixedThreadPool(10);

    CompletableFuture<Boolean> f1 = CompletableFuture.supplyAsync(hotJob, jPool);
    CompletableFuture<Boolean> f2 = CompletableFuture.supplyAsync(washJob, jPool);

    // 任务3：任务1和任务2完成后执⾏：泡茶
    CompletableFuture<Boolean> f3 =
        f1.thenCombine(
            f2,
            (wOk, cOK) -> {
              if (wOk && cOK) {
                log.info("泡茶喝，茶喝完");
                return true;
              } else if (!wOk) {
                log.info("烧水失败，没有茶喝了");
                return false;
              } else if (!cOK) {
                log.info("杯子洗不了，没有茶喝了");
                return false;
              }
              return false;
            });

    log.info(String.valueOf(f3.join()));
  }
}
