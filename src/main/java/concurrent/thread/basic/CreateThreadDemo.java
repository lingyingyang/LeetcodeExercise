package concurrent.thread.basic;

public class CreateThreadDemo {
    static void pong() {
        System.out.print("pong");
    }

    public static void main(String[] args) {
//        runMethod();
        startMethod();
    }

    private static void startMethod() {
        Thread t = new Thread(CreateThreadDemo::pong);
        t.start();
        System.out.print("ping");
    }

    private static void runMethod() {
        Thread t = new Thread(CreateThreadDemo::pong);
        t.run();
        System.out.print("ping");
    }
}
