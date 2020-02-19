package arrays;

import static java.lang.Integer.max;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length, ans = nums[0], left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            left = (left == 0 ? 1 : left) * nums[i];
            right = (right == 0 ? 1 : right) * nums[n - 1 - i];
            ans = max(ans, max(left, right));
        }
        return ans;
    }
}
