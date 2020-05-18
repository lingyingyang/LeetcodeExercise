package leetcode.arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int out = new PivotIndex().pivotIndex(nums);
        assertThat(out).isEqualTo(3);
    }

    public int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == (sum - leftSum - nums[i])) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
