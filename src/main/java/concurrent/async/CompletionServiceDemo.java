package concurrent.async;

import concurrent.async.jobs.HotWaterJob;
import concurrent.async.jobs.WashJob;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CompletionServiceDemo {
  public static void main(String[] args) {
    // 烧水的业务逻辑
    Callable<Boolean> hotJob = new HotWaterJob();
    // 清洗的业务逻辑
    Callable<Boolean> washJob = new WashJob();
    // 创建java 线程池
    ExecutorService jPool = Executors.newFixedThreadPool(10);
    // 创建CompletionService
    CompletionService<Boolean> cs = new ExecutorCompletionService<>(jPool);
    cs.submit(hotJob);
    cs.submit(washJob);

    // 任务3：任务1和任务2完成后执⾏：泡茶
    boolean isOk = true;
    for (int i = 0; i < 2; i++) {
      try {
        isOk = isOk && cs.take().get();
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }
    if (isOk) {
      log.info("泡茶喝，茶喝完");
    }
  }
}
