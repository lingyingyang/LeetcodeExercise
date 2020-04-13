package concurrent.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    private static ReentrantLock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    //与读写锁对比
    private static boolean isReadWriteLock = true;

    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = () -> {
            try {
                if (isReadWriteLock) demo.handleRead(readLock);
                else demo.handleRead(lock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable writeRunnable = () -> {
            try {
                if (isReadWriteLock) demo.handleWrite(writeLock);
                else demo.handleWrite(lock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 2; i++) {
            new Thread(writeRunnable).start();
        }
        for (int i = 0; i < 18; i++) {
            new Thread(readRunnable).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(writeRunnable).start();
        }
    }

    public void handleRead(Lock lock) throws InterruptedException {
        try {
            //模拟读操作
            lock.lock();
            System.out.println("Read Thread: " + Thread.currentThread().getName());
            //读操作的耗时越多，读写锁的优势就越明显
            Thread.sleep(2000);
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock) throws InterruptedException {
        try {
            //模拟写操作
            lock.lock();
            System.out.println("Write Thread: " + Thread.currentThread().getName());
            Thread.sleep(1000);
        } finally {
            lock.unlock();
        }
    }
}
