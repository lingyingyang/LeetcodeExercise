package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 查找两个字符串a,b中的最长公共子串
 */
public class SixtyTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = null;
        while ((s1 = reader.readLine()) != null) {
            String s2 = reader.readLine();
            if (s1.length() >= s2.length()) {
                System.out.println(getCommonString(s1, s2));
            } else {
                System.out.println(getCommonString(s2, s1));
            }
        }
    }

    private static String getCommonString(String s1, String s2) {
        String str = null;
        int len = 0;
        for (int i = 0; i < s2.length(); i++) {
            for (int j = i + len; j < s2.length(); j++) {
                if (s1.contains(s2.substring(i, j + 1))) {
                    len = j - i + 1;
                    str = s2.substring(i, j + 1);
                } else {
                    break;
                }
            }
        }
        return str;
    }
}
