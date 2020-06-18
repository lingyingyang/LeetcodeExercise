package com.huawei;

import java.util.Scanner;

/**
 * 提取不重复的整数
 */
public class Nine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            boolean[] hasExisted = new boolean[10];
            for (int i = s.length() - 1; i >= 0; i--) {
                int num = s.charAt(i) - 48;
                if (!hasExisted[num]) {
                    System.out.print(num);
                    hasExisted[num] = true;
                }
            }
        }
    }
}
