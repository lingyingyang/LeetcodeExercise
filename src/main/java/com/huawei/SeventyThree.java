package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 尼科彻斯定理
 */
public class SeventyThree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            getResult(n);
        }
    }

    public static void getResult(int n) {
        String str = "";
        int mid = (int) (Math.pow(n, 3) / n);
        if (n % 2 == 0) { // n为偶数
            str = (mid - 1) + "+" + (mid + 1);
            int T = n / 2;
            for (int i = 1; i < T; i++) {
                str = (mid - (2 * i) - 1) + "+" + str + "+" + (mid + (2 * i) + 1);
            }
        } else { // n为奇数
            str = mid + "";
            int T = n / 2;
            for (int i = 0; i < T; i++) {
                str = (mid - 2 * (i + 1)) + "+" + str + "+" + (mid + 2 * (i + 1));
            }
        }
        System.out.println(str);
    }
}
