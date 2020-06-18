package com.huawei;

import java.util.Scanner;

/**
 * 查找输入整数二进制中1的个数
 */
public class FiftyNine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int in = sc.nextInt();
            sc.nextLine();
            String s = Integer.toBinaryString(in);
            int ans = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') ans++;
            }
            System.out.println(ans);
        }
    }
}
