package com.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Question3 {
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int out = new Question3().minDays(bloomDay, 3, 1);
        assertEquals(3, out);
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;

        // 算法：二分查找
        int min = 0;
        int max = 0;
        for (int i : bloomDay) max = Math.max(max, i);
        while (min < max) {
            int mid = min + (max - min) / 2;
            // 等待mid天后，多少朵连续的k朵花已经开花了
            int count = getCount(bloomDay, mid, k);
            if (count >= m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private int getCount(int[] bloomDay, int day, int k) {
        // 算法：贪心算法
        int ans = 0;
        int tmpCount = 0;
        for (int item : bloomDay) {
            if (item <= day) tmpCount++;
            else tmpCount = 0;

            // 连续的k朵花开了
            if (tmpCount == k) {
                ans++;
                tmpCount = 0;
            }
        }
        return ans;
    }
}
