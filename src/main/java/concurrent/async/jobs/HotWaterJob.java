package concurrent.async.jobs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public class HotWaterJob implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception //②
    {

        try {
            log.info("洗好水壶");
            log.info("灌上凉水");
            log.info("放在火上");

            //线程睡眠一段时间，代表烧水中
            Thread.sleep(1000);
            log.info("水开了");

        } catch (InterruptedException e) {
            log.info(" 发生异常被中断.");
            return false;
        }
        log.info(" 运行结束.");

        return true;
    }
}