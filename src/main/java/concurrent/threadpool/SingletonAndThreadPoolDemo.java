package concurrent.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SingletonAndThreadPoolDemo {
  public static void main(String[] args) {
    ThreadPoolExecutor executor =
        new ThreadPoolExecutor(
            4,
            4,
            1,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(10),
            new ThreadPoolExecutor.DiscardPolicy());
    for (int i = 0; i < 1000; i++) {
      executor.execute(() -> log.info(String.valueOf(SingletonDemo.instance().hashCode())));
    }
    executor.shutdown();
  }

  static class SingletonDemo {
    private static SingletonDemo instance;

    private SingletonDemo() {}

    public static SingletonDemo instance() {
      if (instance == null) {
        synchronized (SingletonDemo.class) {
          if (instance == null) {
            instance = new SingletonDemo();
          }
        }
      }
      return instance;
    }
  }
}
