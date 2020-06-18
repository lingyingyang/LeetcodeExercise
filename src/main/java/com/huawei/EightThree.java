package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 求最大连续bit数
 */
public class EightThree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            getOneNumber(n);
        }
    }

    public static void getOneNumber(int n) {
        char[] chs = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        for (int i = 0; i < chs.length; ) {
            while (i < chs.length && chs[i] != '1') {
                i++;
            }
            int j = i;
            while (j < chs.length && chs[j] == '1') {
                j++;
                if ((j - i) > count) {
                    count = j - i;
                }
            }
            i = j;
        }
        System.out.println(count);
    }
}
