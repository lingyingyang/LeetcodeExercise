package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 计算字符串的距离
 */
public class Fifty {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sr = null;
        while ((sr = br.readLine()) != null) {
            char[] a = sr.toCharArray();
            char[] b = br.readLine().toCharArray();
            int[][] dp = new int[a.length + 1][b.length + 1];
            for (int i = 1; i <= a.length; i++)
                dp[i][0] = i;
            for (int i = 1; i <= b.length; i++)
                dp[0][i] = i;
            for (int i = 1; i < a.length + 1; i++) {
                for (int j = 1; j < b.length + 1; j++) {
                    if (a[i - 1] == b[j - 1])
                        dp[i][j] = dp[i - 1][j - 1];
                    else
                        dp[i][j] = Math.min(dp[i - 1][j] + 1,
                                Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));

                }
            }
            System.out.println(dp[a.length][b.length]);
        }
    }
}
