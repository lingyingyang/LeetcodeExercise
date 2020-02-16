package arrays;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class PartitionEqualSubsetTest {
    @Test
    void whenTest_thenOk() {
        PartitionEqualSubset test = new PartitionEqualSubset();
        int[] in = new int[]{1, 5, 11, 5};
        boolean actualOut = test.canPartition(in);
        assertTrue(actualOut);
//    [true 0,
//    true 1, false 2, false 3, false 4, true 5, true 6, false 7, false 8, false 9, false 10, true 11]
    }
}