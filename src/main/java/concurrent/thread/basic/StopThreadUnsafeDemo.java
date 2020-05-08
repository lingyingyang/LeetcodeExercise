package concurrent.thread.basic;

import lombok.Data;

/**
 * 写坏了对象
 */
public class StopThreadUnsafeDemo {
    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();
        while (true) {
            Thread t = new ChangeObjectThread();
            t.start();
            Thread.sleep(150);
            t.stop();
        }
    }

    private static final User user = new User();

    @Data
    public static class User {
        private int id = 0;
        private String name = "0";
    }

    public static class ChangeObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    int value = (int) (System.currentTimeMillis() / 1000);
                    user.setId(value);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(value));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    if (user.getId() != Integer.parseInt(user.getName())) {
                        System.out.println(user.toString());
                    }
                }
                Thread.yield();
            }
        }
    }
}
