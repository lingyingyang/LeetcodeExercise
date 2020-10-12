package leetcode.dp;

import static java.lang.Math.min;
import static org.assertj.core.api.Assertions.assertThat;

public class PaintHouse {
    public static void main(String[] args) {
        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        int out = new PaintHouse().minCost(costs);
        assertThat(out).isEqualTo(10);
    }

    public int minCost(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) return 0;

        int size = costs.length + 1;
        int conditions = costs[0].length;
        int[][] dp = new int[size][conditions];
        for (int i = 1; i < size; i++) {
            int prev = i - 1;
            for (int j = 0; j < conditions; j++) {
                dp[i][j] =
                        min(costs[prev][(j + 1) % conditions], costs[prev][(j + 2) % conditions]) + dp[prev][j];
            }
        }

        int out = Integer.MAX_VALUE;
        for (int i = 0; i < conditions; i++) {
            out = min(dp[size - 1][i], out);
        }
        return out;
    }
}
