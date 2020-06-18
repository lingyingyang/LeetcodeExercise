package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 挑7
 */
public class FiftyTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int N = Integer.parseInt(str);
            int count = 0;
            for (int i = 7; i <= N; i++) {
                if (i % 7 == 0) { // 7的倍数
                    count++;
                    continue;
                }

                if (i % 10 == 7) { // 个位
                    count++;
                    continue;
                }

                int k = i / 10; // 多位
                while (k != 0) {
                    if (k % 10 == 7) {
                        count++;
                        break;
                    } else {
                        k = k / 10;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
