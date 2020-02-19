package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumProductSubarrayTest {
    @Test
    void whenTest_thenOk() {
        MaximumProductSubarray test = new MaximumProductSubarray();
        int[] in = new int[]{-2, -1, 2, 3, -2, 4};
        int actualOut = test.maxProduct(in);
        assertEquals(48, actualOut);
    }
}