package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字符串通配符
 */
public class SixtyEight {
    public static boolean isMatch(String str1, String str2) {
        str1 = str1.replaceAll("\\?", "[0-9a-zA-Z]"); // 把str1变成正则表达式
        str1 = str1.replaceAll("\\*", "[0-9a-zA-Z]*");
        str1 = str1.replaceAll("\\.", "\\.");
        return str2.matches(str1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = "";
        while ((s1 = br.readLine()) != null) {
            String s2 = br.readLine();
            System.out.println(isMatch(s1, s2));
        }
    }
}
