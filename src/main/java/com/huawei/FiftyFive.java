package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 输入n个整数，输出其中最小的k个
 */
public class FiftyFive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            String[] params = str.split(" ");
            int n = Integer.parseInt(params[0]);
            int k = Integer.parseInt(params[1]);

            String line = br.readLine();
            String[] array = line.split(" ");

            int[] intArr = new int[n];
            for (int i = 0; i < intArr.length; i++) {
                intArr[i] = Integer.parseInt(array[i]);
            }
            Arrays.sort(intArr);
            for (int i = 0; i < k; i++) {
                if (i == k - 1)
                    System.out.println(intArr[i]);
                else
                    System.out.print(intArr[i] + " ");
            }
        }
    }

}
