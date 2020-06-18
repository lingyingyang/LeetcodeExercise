package com.huawei;

import java.util.Scanner;

/**
 * 计算字符个数
 */
public class Two {
    public static int result(String in, char c) {
        int count = 0;
        if (in != null && in.length() > 0) {
            for (int i = 0; i < in.length(); i++) {
                if (c == in.charAt(i)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String in = input.nextLine().toLowerCase();
        char c = Character.toLowerCase(input.nextLine().charAt(0));
        System.out.println(result(in, c));
    }
}
