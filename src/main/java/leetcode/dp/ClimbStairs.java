package leetcode.dp;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode/
 */
public class ClimbStairs {
    public static void main(String[] args) {
        ClimbStairs t = new ClimbStairs();
        int num = t.climbStairs(3);
        System.out.println(num);
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
