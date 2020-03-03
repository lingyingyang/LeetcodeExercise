package leetcode.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * 0/1 Knapsack problem, can any element sum up to half sum?
 * if yes, return true.
 */
@Slf4j
public class PartitionEqualSubset {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        log.info("sum: {}", sum);

        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
            log.info("leetcode.dp[]: {}", Arrays.toString(dp));
            if (dp[sum]) return true;
        }

        return false;
    }
}
