package leetcode.arrays;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-100, -98, -2, -1};
        int out = new ThreeSumClosest().threeSumClosest(nums, -101);
        assertEquals(-101, out);
    }

    public int threeSumClosest(int[] nums, int target) {
        int best = 100000;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int curr = nums[i];
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = curr + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    right--;
                } else {
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                }
            }
        }

        return best;
    }
}
