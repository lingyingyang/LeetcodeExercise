package leetcode.sort;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort t = new QuickSort();
        int[] nums = new int[]{3, 6, 1, 2, 4, 0, 8, 7, 6};
        t.quickSort(nums);
        assertThat(Arrays.toString(nums)).isEqualTo("[0, 1, 2, 3, 4, 6, 6, 7, 8]");
    }

    public void quickSort(int[] nums) {
        helper(nums, 0, nums.length - 1);
    }

    private void helper(int[] nums, int head, int tail) {
        if (head >= tail) return;

        int pivot = partition(nums, head, tail);
        helper(nums, head, pivot - 1);
        helper(nums, pivot + 1, tail);
    }

    private int partition(int[] nums, int head, int tail) {
        //取得pivot
        int pivot = head + (int) (Math.random() * (tail - head + 1));
        swap(nums, head, pivot);

        int idx = head + 1;
        for (int i = head + 1; i <= tail; i++) {
            if (nums[i] < nums[head]) {
                swap(nums, idx++, i);
            }
        }

        swap(nums, head, --idx);
        return idx;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];

//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
    }
}
