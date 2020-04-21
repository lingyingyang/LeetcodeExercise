package leetcode.arrays;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/count-number-of-nice-subarrays/solution/tong-ji-you-mei-zi-shu-zu-by-leetcode-solution/
 */
public class NumberOfNiceSubArrays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        NumberOfNiceSubArrays t = new NumberOfNiceSubArrays();
        int out = t.numberOfSubarrays(nums, 3);
        System.out.println(out);//2
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] cnt = new int[len + 1];//频次数组
        Arrays.fill(cnt, 0);
        int odds = 0, ans = 0;
        cnt[0] = 1;
        for (int num : nums) {
            odds += num & 1;//按位与1，奇数返回1，偶数返回0
            ans += (odds >= k) ? cnt[odds - k] : 0;
            cnt[odds] += 1;
        }
        return ans;
    }
}
