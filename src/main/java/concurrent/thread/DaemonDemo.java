package concurrent.thread;

public class DaemonDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new DaemonThread();
        //如果不设置t为守护线程，main线程结束后它会一直运行下去
//        t.setDaemon(true);
        t.start();
        Thread.sleep(2000);
        System.out.println("Main end!");
    }

    public static class DaemonThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("I'm alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
