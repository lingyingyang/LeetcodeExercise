package numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountPrimesTest {
    @Test
    void whenTest_thenOk() {
        CountPrimes countPrimes = new CountPrimes();
        int result = countPrimes.getResult(10);
        System.out.println(result);
        assertEquals(4, result);
    }
}