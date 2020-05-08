package stream;

import java.util.stream.IntStream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        long out = IntStream.range(1, 1000000).parallel().filter(PrimeUtil::isPrime).count();
        System.out.println(out);
    }
}
