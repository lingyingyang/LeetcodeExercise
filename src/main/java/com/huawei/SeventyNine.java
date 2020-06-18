package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 将真分数分解为埃及分数
 */
public class SeventyNine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while ((input = br.readLine()) != null) {

            ConvertRealFractToEgpytFract(input);
        }
    }

    public static void ConvertRealFractToEgpytFract(String pcRealFraction) {
        String[] parts = pcRealFraction.split("/");

        int a = Integer.parseInt(parts[0]);

        int b = Integer.parseInt(parts[1]);

        StringBuilder result = new StringBuilder();

        int c = 0;
        while (a != 1) {
            if (b % (a - 1) == 0) {
                result.append("1/").append(b / (a - 1)).append('+');
                a = 1;
            } else {
                c = b / a + 1;
                result.append("1/").append(c).append('+');
                a = a * c - b;
                b = c * b;
                if (b % a == 0) {
                    b = b / a;
                    a = 1;
                }
            }
        }
        result.append("1/").append(b);
        System.out.println(result);
    }
}
