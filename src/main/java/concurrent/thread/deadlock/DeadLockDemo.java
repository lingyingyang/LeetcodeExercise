package concurrent.thread.deadlock;

/**
 * 最简单的情况就是只有两个哲学家，假设是A和B，桌面也只有两个叉子。A左手拿着其中一只叉子，B也一样。
 * 这样他们的右手等待对方的叉子，并且这种等待会一直持续，从而导致程序永远无法正常执行。
 */
public class DeadLockDemo extends Thread {
    public static void main(String[] args) throws InterruptedException {
        DeadLockDemo a = new DeadLockDemo(fork1);
        DeadLockDemo b = new DeadLockDemo(fork2);
        a.start();
        b.start();
        Thread.sleep(1000);
    }

    protected Object tool;
    static final Object fork1 = new Object();
    static final Object fork2 = new Object();

    public DeadLockDemo(Object obj) {
        this.tool = obj;
        if (tool == fork1)
            this.setName("哲学家A");
        if (tool == fork2)
            this.setName("哲学家B");
    }

    @Override
    public void run() {
        if (tool == fork1) {
            synchronized (fork1) {//哲学家A占用fork1
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (fork2) {//哲学家A想拿起fork2来进餐
                    System.out.println("哲学家A开始吃饭了");
                }
            }
        }
        if (tool == fork2) {
            synchronized (fork2) {//哲学家B占用fork2
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (fork1) {//哲学家B想拿起fork1来进餐
                    System.out.println("哲学家B开始吃饭了");
                }
            }
        }
    }
}
