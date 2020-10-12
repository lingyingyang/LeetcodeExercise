package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 表示数字
 */
public class NinetyThree {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            int temp = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= '0' && c <= '9') {
                    if (temp == 0) {
                        System.out.print("*");
                        temp = 1;
                    }
                } else {
                    if (temp == 1) {
                        System.out.print("*");
                        temp = 0;
                    }
                }
                System.out.print(c);
            }
            char c = str.charAt(str.length() - 1);
            if (c >= '0' && c <= '9') System.out.print("*");
            System.out.println();
        }
        bf.close();
    }
}
