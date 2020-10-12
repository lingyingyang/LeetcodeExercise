package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 记负均正II
 */
public class HundredTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while ((line = bReader.readLine()) != null) {
            String[] ins = line.split(" ");
            int negNum = 0;
            int noNegNum = 0;
            int total = 0;
            for (String s : ins) {
                int x = Integer.parseInt(s);
                if (x < 0) negNum++;
                else {
                    noNegNum++;
                    total += x;
                }
            }
            System.out.println(negNum);
            System.out.format("%.1f", (float) total / noNegNum);
            System.out.println();
        }
    }
}
