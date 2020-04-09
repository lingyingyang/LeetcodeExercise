package concurrent.async.jobs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public class WashJob implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        try {
            log.info("洗茶壶");
            log.info("洗茶杯");
            log.info("拿茶叶");
            //线程睡眠一段时间，代表清洗中
            Thread.sleep(2000);
            log.info("洗完了");

        } catch (InterruptedException e) {
            log.info(" 清洗工作 发生异常被中断.");
            return false;
        }
        log.info(" 清洗工作  运行结束.");
        return true;
    }
}