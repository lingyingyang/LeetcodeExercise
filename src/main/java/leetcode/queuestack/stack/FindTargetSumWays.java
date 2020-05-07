package leetcode.queuestack.stack;

import static org.assertj.core.api.Assertions.assertThat;

public class FindTargetSumWays {
    public static void main(String[] args) {
        FindTargetSumWays t = new FindTargetSumWays();
        int[] nums = {1, 1, 1, 1, 1};
        int out = t.findTargetSumWays(nums, 3);
        assertThat(out).isEqualTo(5);
    }

    private int cnt = 0;

    public int findTargetSumWays(int[] nums, int s) {
        dfsHelper(nums, 0, 0, s);
        return cnt;
    }

    private void dfsHelper(int[] nums, int idx, int sum, int s) {
        if (idx == nums.length) {
            if (sum == s) {
                cnt++;
            }
        } else {
            dfsHelper(nums, idx + 1, sum + nums[idx], s);
            dfsHelper(nums, idx + 1, sum - nums[idx], s);
        }
    }

}
