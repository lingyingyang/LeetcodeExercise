package com.huawei;

import java.util.Scanner;

/**
 * 蛇形矩阵
 */
public class ThirtyFive {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                for (int j = 1, start = (i - 1) * i / 2 + 1, step = i + 1;
                     j <= n - i + 1;
                     j++, start += step, step++) {
                    builder.append(start).append(' ');
                }
                // 设置换行符
                builder.setCharAt(builder.length() - 1, '\n');
            }
            System.out.print(builder.toString());
        }
    }
}
