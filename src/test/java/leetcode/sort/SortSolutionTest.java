package leetcode.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortSolutionTest {
    private SortSolution t;

    @BeforeEach
    void setUp() {
        t = new SortSolution();
    }

    @Test
    void test() {
        int out = (2 + 3) >>> 1;
        System.out.println(out);
    }

    @Test
    void sortArray() {
        int[] nums = new int[]{3, 6, 1, 2, 4, 0, 8, 7, 6};
        int[] out = t.sortArray(nums);
        System.out.println(Arrays.toString(out));
    }

    @Test
    void quickSort() {
        int[] nums = new int[]{3, 6, 1, 2, 4, 0, 8, 7, 6};
        t.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    void mergeSort() {
        int[] nums = new int[]{3, 6, 1, 2, 4, 0, 8, 7, 6};
        t.mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}