package leetcode.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountPrimesTest {
    @Test
    void whenResult_thenOk() {
        CountPrimes countPrimes = new CountPrimes();
        int result = countPrimes.result(10);
        System.out.println(result);
        assertEquals(4, result);
    }
}