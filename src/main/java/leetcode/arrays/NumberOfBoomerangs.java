package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfBoomerangs {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        int out = new NumberOfBoomerangs().numberOfBoomerangs(points);
        assertEquals(2, out);
    }

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] pointA : points) {
            Map<Integer/*距离*/, Integer/*数量*/> map = new HashMap<>();
            for (int[] pointB : points) {
                int dx = pointA[0] - pointB[0];
                int dy = pointA[1] - pointB[1];
                int dPower = dx * dx + dy * dy;
                map.put(dPower, map.getOrDefault(dPower, 0) + 1);
            }
            for (Integer val : map.values()) {
                ans += val * (val - 1);
            }
        }
        return ans;
    }
}
