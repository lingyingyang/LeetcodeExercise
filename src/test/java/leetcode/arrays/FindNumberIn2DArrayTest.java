package leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FindNumberIn2DArrayTest {
    @Test
    void test() {
        FindNumberIn2DArray test = new FindNumberIn2DArray();
        int[][] in = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        assertTrue(test.findNumberIn2DArray(in, 5));
        assertFalse(test.findNumberIn2DArray(in, 20));
    }
}