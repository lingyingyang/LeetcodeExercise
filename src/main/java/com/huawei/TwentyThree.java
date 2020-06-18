package com.huawei;

import java.util.Scanner;

/**
 * 删除字符串中出现次数最少的字符
 */
public class TwentyThree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            if (str.length() > 20) {
                continue;
            }
            int[] words = new int[26];
            char[] ch = str.toCharArray();
            int min = Integer.MAX_VALUE;
            for (char c : ch) {
                words[c - 'a']++;
                min = Math.min(min, words[c - 'a']);
            }

            for (int i = 0; i < words.length; i++) {
                if (words[i] == min) {
                    str = str.replaceAll(String.valueOf((char) (i + 97)), "");
                }
            }
            System.out.println(str);
        }
    }
}
