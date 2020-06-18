package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Redraiment的走法
 */
public class Hundred {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            String[] data = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < data.length; i++) {
                arr[i] = Integer.parseInt(data[i]);
            }

            int[] brr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                brr[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[j] < arr[i]) {
                        brr[i] = Math.max(brr[i], brr[j] + 1);
                    }
                }
            }

            int max = 0;
            for (int aBrr : brr) {
                if (max < aBrr) {
                    max = aBrr;
                }
            }

            System.out.println(max);
        }
    }
}
