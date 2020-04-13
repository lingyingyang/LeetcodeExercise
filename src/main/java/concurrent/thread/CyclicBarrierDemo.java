package concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        final int number = 10;
        Thread[] soldiers = new Thread[number];
        CyclicBarrier cyclicBarrier = new CyclicBarrier(number, new BarrierRun(false, number));
        //设置屏障点，主要是为了执行这个方法
        log.info("集合队伍！");
        for (int i = 0; i < number; i++) {
            soldiers[i] = new Thread(new Soldier(cyclicBarrier, "士兵" + i));
            soldiers[i].start();
            //模拟异常的情况
//            if (i == 5) {
//                soldiers[i].interrupt();
//            }
        }
    }

    public static class Soldier implements Runnable {
        private String soldierName;
        private final CyclicBarrier cyclicBarrier;

        public Soldier(CyclicBarrier cyclicBarrier, String soldierName) {
            this.cyclicBarrier = cyclicBarrier;
            this.soldierName = soldierName;
        }

        @Override
        public void run() {
            try {
                //等待所有士兵到齐
                log.info("{}报道！", soldierName);
                cyclicBarrier.await();
                doWork();
                //等待所有士兵完成工作
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldierName + ":任务完成！");
        }
    }

    public static class BarrierRun implements Runnable {
        boolean flag;
        int number;

        public BarrierRun(boolean flag, int number) {
            this.flag = flag;
            this.number = number;
        }

        @Override
        public void run() {
            if (flag) {
                log.info("司令：士兵{}个，任务完成！", number);
            } else {
                log.info("司令：士兵{}个，集合完毕！", number);
                flag = true;
            }
        }
    }
}
