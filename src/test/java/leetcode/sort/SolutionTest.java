package leetcode.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {
    @Test
    void name() {
        Solution test = new Solution();
        int[] in = new int[]{3, 6, 1, 2, 4, 0, 8, 7, 6};
        test.quickSort(in);
        System.out.println(Arrays.toString(in));
    }
}