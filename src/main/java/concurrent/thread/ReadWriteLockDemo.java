package concurrent.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static final Lock readLock = readWriteLock.readLock();
    private static final Lock writeLock = readWriteLock.writeLock();
    /**
     * ReentrantLock与读写锁对比<br/>
     * true: 使用读写锁<br/>
     * false：使用ReentrantLock
     */
    private static final boolean isReadWriteLock = true;

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

    public void handleRead(Lock readLock) throws InterruptedException {
        try {
            //模拟读操作
            readLock.lockInterruptibly();
            System.out.println("Read Thread: " + Thread.currentThread().getName());
            //读操作的耗时越多，读写锁的优势就越明显
            Thread.sleep(2000);
        } finally {
            readLock.unlock();
        }
    }

    public void handleWrite(Lock writeLock) throws InterruptedException {
        try {
            //模拟写操作
            writeLock.lockInterruptibly();
            System.out.println("Write Thread: " + Thread.currentThread().getName());
            Thread.sleep(1000);
        } finally {
            writeLock.unlock();
        }
    }
}
