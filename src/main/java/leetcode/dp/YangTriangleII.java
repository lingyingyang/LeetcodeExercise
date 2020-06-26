package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角2
 */
public class YangTriangleII {
    public static void main(String[] args) {
        List<Integer> out = new YangTriangleII().getRow(3);
        System.out.println(out.toString());
    }

    public List<Integer> getRow(int rowIndex) {
        int[] dp = new int[rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            dp[i] = 1;
            for (int j = i; j > 1; j--) {
                dp[j - 1] = dp[j - 1] + dp[j - 2];
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int item : dp) {
            ans.add(item);
        }
        return ans;
    }
}
