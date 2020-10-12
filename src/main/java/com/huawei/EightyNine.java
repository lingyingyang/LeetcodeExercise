package com.huawei;

import java.util.Scanner;

/**
 * 在字符串中找出连续最长的数字串
 */
public class EightyNine {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            StringBuilder sb = new StringBuilder();
            String str = scan.nextLine();
            for (char ch : str.toCharArray()) {
                // 将不是数字的字符全部变成a
                if (ch >= '0' && ch <= '9') {
                    sb.append(ch);
                } else {
                    sb.append("a");
                }
            }
            // 按a分割
            String[] strings = sb.toString().split("a");
            int max = 0; // 记录最长的连续数字串的长度
            for (String string : strings) {
                max = Math.max(string.length(), max);
            }
            for (String string : strings) {
                if (string.length() == max) System.out.print(string);
            }
            System.out.println("," + max);
        }
  }
}
