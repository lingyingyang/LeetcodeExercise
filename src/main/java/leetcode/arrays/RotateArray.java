package leetcode.arrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray t = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        t.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        if (nums.length == 0) return;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length; j++) {
                swap(nums, j, nums.length - 1);
            }
        }
    }

    private void swap(int[] nums, int s, int e) {
        int tmp = nums[s];
        nums[s] = nums[e];
        nums[e] = tmp;
    }
}
