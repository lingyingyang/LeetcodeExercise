package leetcode.dp;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode/
 */
public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray t = new MaxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = t.maxSubArray(nums);
        System.out.println(max);
    }

    /**
     * 贪心算法
     */
    public int maxSubArray(int[] nums) {
        int currMax = nums[0];
        int max = currMax;
        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            max = Math.max(currMax, max);
        }
        return max;
    }

    public int dp(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}
