import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int value = 0;

    private final Lock lock = new ReentrantLock();

    public int getValue() {
        return value;
    }

    public void increment() {
        lock.lock();
        value++;
        lock.unlock();
    }

}
