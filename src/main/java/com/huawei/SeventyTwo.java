package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 公共字串计算
 */
public class SeventyTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string1 = "";
        while ((string1 = br.readLine()) != null) {
            String string2 = br.readLine();
            char[] str1 = string1.toCharArray();
            char[] str2 = string2.toCharArray();
            int[][] dp = new int[str1.length][str2.length];
            for (int i = 0; i < str1.length; i++) {
                if (str1[i] == str2[0]) {
                    dp[i][0] = 1;
                }
            }
            for (int j = 1; j < str2.length; j++) {
                if (str2[j] == str1[0]) {
                    dp[0][j] = 1;
                }
            }
            int max = 0;
            for (int i = 1; i < str1.length; i++) {
                for (int j = 1; j < str2.length; j++) {
                    if (str1[i] == str2[j]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
            System.out.println(max);
        }
    }
}
