package concurrent.thread.basic;

/**
 * 中断线程，可防止写坏数据，与StopThreadUnsafeDemo比较
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {//中断后处理的逻辑
                        System.out.println("Interrupted!");
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupt the thread when sleep");
                        //设置中断状态
                        Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
            }
        };
        t.start();
        Thread.sleep(1000);
        t.interrupt();
    }
}
