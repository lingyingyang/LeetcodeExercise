package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字符串排序
 */
public class TwentySix {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                char c = (char) (i + 'A');
                for (int j = 0; j < str.length(); j++) {
                    char sc = str.charAt(j);
                    if (c == sc || c == sc - 32) {
                        builder.append(sc);
                    }
                }
            }
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z')) {
                    builder.insert(i, c);
                }
            }
            System.out.println(builder.toString());
        }
        bf.close();
    }
}
