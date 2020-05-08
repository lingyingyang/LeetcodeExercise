package concurrent.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockConditionDemo implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockConditionDemo demo = new ReentrantLockConditionDemo();
        Thread thread = new Thread(demo, "ReentrantLockConditionDemo");
        thread.start();
        Thread.sleep(2000);
        try {
            //通知thread继续运行
            lock.lock();
            condition.signal();//获得锁才可以使用
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread start!");
            lock.lock();
            condition.await();//获得锁才可以使用
            System.out.println("Thread is going on!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
