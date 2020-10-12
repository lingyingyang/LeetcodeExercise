package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 直线上最多的点数
 */
public class MaxPoints {
    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int out = new MaxPoints().maxPoints(points);
        assertEquals(4, out);
    }

    public int maxPoints(int[][] points) {
        if (points == null) return 0;

        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            int[] currPoint = points[i];
            int duplicate = 0;
            int max = 0;
            Map<String /*斜率*/, Integer /*数量*/> countMap = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                // 求分子分母
                int x = points[j][0] - currPoint[0];
                int y = points[j][1] - currPoint[1];
                if (x == 0 && y == 0) {
                    duplicate++;
                    continue;
                }
                // 约分
                int gcd = gcd(x, y);
                x /= gcd;
                y /= gcd;
                String key = x + "/" + y;
                countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                max = Math.max(max, countMap.get(key));
            }
            // 1 代表当前考虑的点，duplicate 代表和当前的点重复的点
            ans = Math.max(ans, max + duplicate + 1);
        }

        return ans;
    }

    private int gcd(int x, int y) {
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }
}
