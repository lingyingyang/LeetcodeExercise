package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 称砝码
 */
public class ThirtyNine {
    private static int weight(int n, int[] weight, int[] nums) {
        int sum = 0;
        // 单种砝码可以表示的
        for (int i = 0; i < n; i++) { // 种类数
            sum = sum + nums[i] * weight[i];
        }
        boolean[] weg = new boolean[sum + 1];
        weg[0] = true;
        weg[sum] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nums[i]; j++) {
                for (int k = sum; k >= weight[i]; k--) {
                    if (weg[k - weight[i]]) {
                        weg[k] = true;
                    }
                }
            }
        }
        int count = 0;
        for (boolean b : weg) {
            if (b) count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {

            int n = Integer.parseInt(str);
            String[] weightStr = bf.readLine().split(" ");
            String[] numsStr = bf.readLine().split(" ");

            int[] weight = new int[weightStr.length];
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < n; i++) {
                weight[i] = Integer.parseInt(weightStr[i]);
                nums[i] = Integer.parseInt(numsStr[i]);
            }
            System.out.println(weight(n, weight, nums));
        }

        bf.close();
    }
}
