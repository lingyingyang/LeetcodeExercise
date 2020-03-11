package alibaba;

import org.junit.jupiter.api.Test;

import java.util.Random;

class SolutionTest {
    @Test
    void name() {
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.println((r.nextInt(10) + 1) * 10000);
        }
    }
}