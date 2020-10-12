package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 统计大写字母个数
 */
public class EightOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println(CalcCapital(line));
        }
    }

    private static int CalcCapital(String line) {
        int sum = 0;
        for (int i = 0; i < line.length(); ++i)
            if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') ++sum;

        return sum;
    }
}
