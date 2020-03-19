package concurrent;

public class ThreadDemo {
    static void pong() {
        System.out.print("pong");
    }

    public static void main(String[] args) {
//        runMethod();
        startMethod();
    }

    private static void startMethod() {
        Thread t = new Thread(ThreadDemo::pong);
        t.start();
        System.out.print("ping");
    }

    private static void runMethod() {
        Thread t = new Thread(ThreadDemo::pong);
        t.run();
        System.out.print("ping");
    }
}
