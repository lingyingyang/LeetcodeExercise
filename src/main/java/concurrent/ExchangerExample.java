package concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ExchangerExample {
    private static final Exchanger<String> exchanger = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(() -> {
            try {
                String a = "银行流水A";// A录入银行流水数据
                log.info("a before exchange()");
                String b = exchanger.exchange(a);
                log.info("a - A和B数据是否一致：{}, A录入的是：{}, B录入是：{}", a.equals(b), a, b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.execute(() -> {
            try {
                String b = "银行流水B";// B录入银行流水数据
                log.info("b before exchange()");
                String a = exchanger.exchange(b);
                log.info("b - A和B数据是否一致：{}, A录入的是：{}, B录入是：{}", a.equals(b), a, b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadPool.shutdown();
    }
}
