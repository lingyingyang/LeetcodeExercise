package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        FourSumII t = new FourSumII();
        int out = t.fourSumCount(A, B, C, D);
        System.out.println(out);//2
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int a : A) {
            for (int b : B) {//遍历A和B
                int sumAB = a + b;
                if (map.containsKey(sumAB))
                    map.put(sumAB, map.get(sumAB) + 1);
                else map.put(sumAB, 1);
            }
        }

        for (int c : C) {
            for (int d : D) {//遍历C和D
                int sumCD = -(c + d);
                if (map.containsKey(sumCD))//四数相加等于0
                    res += map.get(sumCD);//累加这种情况的次数
            }
        }
        return res;
    }
}
