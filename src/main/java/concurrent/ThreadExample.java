package concurrent;

public class ThreadExample {
    static void pong() {
        System.out.print("pong");
    }

    public static void main(String[] args) {
//        runMethod();
        startMethod();
    }

    private static void startMethod() {
        Thread t = new Thread(ThreadExample::pong);
        t.start();
        System.out.print("ping");
    }

    private static void runMethod() {
        Thread t = new Thread(ThreadExample::pong);
        t.run();
        System.out.print("ping");
    }
}
