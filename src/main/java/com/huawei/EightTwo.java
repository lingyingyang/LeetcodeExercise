package com.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 字符串运用-密码截取
 */
public class EightTwo {
    public static int getLongestStr(String str) {
        int maxLen = -1;
        // 奇数
        for (int i = 0; i < str.length(); ++i) {
            int j = i - 1;
            maxLen = get(str, maxLen, i, j);
        }

        for (int i = 0; i < str.length(); ++i) {
            int j = i;
            maxLen = get(str, maxLen, i, j);
        }
        return maxLen;
    }

    private static int get(String str, int maxLen, int i, int j) {
        int k = i + 1;
        while (j >= 0 && k < str.length() && str.charAt(j) == str.charAt(k)) {
            if ((k - j + 1) > maxLen) maxLen = k - j + 1;
            j--;
            k++;
        }
        return maxLen;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null && !("".equals(str))) {
            int num = getLongestStr(str);
            System.out.println(num);
        }
    }
}
