package concurrent.async;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JoinDemo {
  public static void main(String[] args) {
    Thread hThread = new HotWaterThread();
    Thread wThread = new WashThread();

    hThread.start();
    wThread.start();
    try {
      // 合并烧水-线程
      hThread.join();
      // 合并清洗-线程
      wThread.join();

      Thread.currentThread().setName("主线程");
      log.info("泡茶喝");
    } catch (InterruptedException e) {
      log.info(getCurThreadName() + "发生异常被中断.");
    }
    log.info(getCurThreadName() + " 运行结束.");
  }

  public static final int SLEEP_GAP = 500;

  public static String getCurThreadName() {
    return Thread.currentThread().getName();
  }

  static class HotWaterThread extends Thread {
    public HotWaterThread() {
      super("** 烧水-Thread");
    }

    public void run() {
      try {
        log.info("洗好水壶");
        log.info("灌上凉水");
        log.info("放在火上");

        // 线程睡眠一段时间，代表烧水中
        Thread.sleep(SLEEP_GAP);
        log.info("水开了");

      } catch (InterruptedException e) {
        log.info(" 发生异常被中断.");
      }
      log.info(" 运行结束.");
    }
  }

  static class WashThread extends Thread {
    public WashThread() {
      super("$$ 清洗-Thread");
    }

    public void run() {

      try {
        log.info("洗茶壶");
        log.info("洗茶杯");
        log.info("拿茶叶");
        // 线程睡眠一段时间，代表清洗中
        Thread.sleep(SLEEP_GAP);
        log.info("洗完了");

      } catch (InterruptedException e) {
        log.info(" 发生异常被中断.");
      }
      log.info(" 运行结束.");
    }
  }
}
