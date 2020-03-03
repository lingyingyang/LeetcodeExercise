package leetcode.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfTwoSortedArraysTest {
    @Test
    void whenValidate_thenOk() {
        MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();
        int[] nums = new int[]{5, 7, 7, 8, 8, 8, 10};
        int target = 8;
        int[] actual = test.searchRange(nums, target);
        int[] expect = new int[]{3, 5};
        assertEquals(Arrays.toString(expect), Arrays.toString(actual));
    }

    @Test
    void whenTest_thenOk() {
        int mid = 7 / 2;
        System.out.println(mid);
        assertEquals(3, mid);
    }
}