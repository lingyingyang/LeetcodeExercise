package leetcode.arrays;

import java.util.Arrays;

public class MoveZero {
    public static void main(String[] args) {
        MoveZero t = new MoveZero();
        int[] nums = {0, 1, 0, 3, 12};
        t.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        if (nums.length == 0) return;
        //1 fast遇到非零时，与slow互换
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                swap(nums, slow, fast);
                slow++;
            }
            fast++;
        }
    }

    private void swap(int[] nums, int slow, int fast) {
        int tmp = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = tmp;
    }
}
