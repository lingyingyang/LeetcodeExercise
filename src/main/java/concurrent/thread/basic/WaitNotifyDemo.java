package concurrent.thread.basic;

public class WaitNotifyDemo {
    final static Object object = new Object();

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T1 start!");
                try {
                    System.out.println(System.currentTimeMillis() + ":T1 wait for object");
                    object.wait();//获得锁才可以使用
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 end!");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T2 start! And notify one thread");
                object.notify();//获得锁才可以使用
                System.out.println(System.currentTimeMillis() + ":T2 end! and sleep 2s, then release object's lock");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
