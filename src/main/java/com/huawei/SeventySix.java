package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 计算字符串的相似度
 */
public class SeventySix {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s1 = "";
        while (null != (s1 = in.readLine())) {
            //将两个输入字符串转为数组
            String s2 = in.readLine();
            char[] cs1 = s1.toCharArray();
            char[] cs2 = s2.toCharArray();
            int[][] dp = new int[s1.length() + 1][s2.length() + 1];
            //用动态规划的方式获取一个数组变为另一个数组的步骤次数
            //初始化二维数组
            for (int row = 1; row <= s1.length(); row++) {
                dp[row][0] = row;
            }
            for (int col = 1; col <= s2.length(); col++) {
                dp[0][col] = col;
            }
            //动态规划
            for (int row = 1; row <= s1.length(); row++) {
                for (int col = 1; col <= s2.length(); col++) {
                    if (cs1[row - 1] == cs2[col - 1]) {
                        dp[row][col] = dp[row - 1][col - 1];
                    } else {
                        int min1 = Math.min(dp[row - 1][col], dp[row][col - 1]) + 1;
                        dp[row][col] = Math.min(min1, dp[row - 1][col - 1] + 1);

                    }
                }
            }
            System.out.println("1/" + (dp[s1.length()][s2.length()] + 1));
        }
    }
}
