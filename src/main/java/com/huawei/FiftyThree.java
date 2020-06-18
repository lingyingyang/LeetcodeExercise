package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 完全数计算
 */
public class FiftyThree {
    public static void main(String[] args) throws IOException {
        BufferedReader bfd = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = bfd.readLine()) != null) {
            int n = Integer.parseInt(str);
            int count = 0;
            for (int i = 2; i <= n; i++) {
                if (isPerfect(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static boolean isPerfect(int num) {
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += 1;
                sum += num / i;
            }
        }
        return sum == num;
    }
}
