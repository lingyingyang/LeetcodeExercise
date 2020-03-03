package leetcode.dp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MinimumPathSumTest {
    @Test
    void whenTest_thenOk() {
        MinimumPathSum test = new MinimumPathSum();
        int[][] in = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        int actualOut = test.minPathSum(in);
        log.info("result: {}", actualOut);
        assertEquals(7, actualOut);
    }
}