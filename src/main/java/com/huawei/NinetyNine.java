package com.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 字符统计
 */
public class NinetyNine {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(fun(line));
        }
    }

    private static String fun(String str) {
        char[] chs = str.toCharArray();
        int[] num = new int[200];     //必须大于128
        for (char c : chs) {
            num[(int) c]++;
        }

        int max = 0;
        for (int value : num) {
            if (max < value) {
                max = value;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (max != 0) {
            for (int i = 0; i < num.length; i++) {
                if (max == num[i]) {
                    sb.append((char) i);
                }
            }
            max--;
        }
        return sb.toString();
    }
}
