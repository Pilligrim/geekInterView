public class PinPong {
    private final Object monitor = new Object();
    private volatile String game = "PING";

    public static void main(String[] args) {
        PinPong w = new PinPong();
        Thread t1 = new Thread(() -> {
            w.printPing();
        });
        Thread t2 = new Thread(() -> {
            w.printPong();
        });
        t1.start();
        t2.start();
    }

    public void printPing() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (!"PING".equals(game)) {
                        monitor.wait();
                    }
                    System.out.println("PING");
                    game = "PONG";
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printPong() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (!"PONG".equals(game)) {
                        monitor.wait();
                    }
                    System.out.println("PONG");
                    game = "PING";
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
