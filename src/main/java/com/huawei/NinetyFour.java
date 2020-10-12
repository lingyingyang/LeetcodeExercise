package com.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 记负均正
 */
public class NinetyFour {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line);
            int negativeCount = 0;
            int positiveCount = 0;
            int positiveSum = 0;
            String[] strings = br.readLine().split(" ");
            for (String string : strings) {
                int temp = Integer.parseInt(string);
                if (temp > 0) {
                    ++positiveCount;
                    positiveSum += temp;
                } else if (temp < 0) ++negativeCount;
            }
            System.out.printf("%d %.1f\n", negativeCount, positiveSum * 1.0 / positiveCount);
        }
    }
}
