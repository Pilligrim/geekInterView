import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CounterTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Counter counter = new Counter();

        IntStream.range(0, 100_000).forEach(count -> service.submit(counter::increment));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        System.out.println(counter.getValue());
        service.shutdown();
    }
}
