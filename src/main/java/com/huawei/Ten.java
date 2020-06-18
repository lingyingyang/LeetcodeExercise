package com.huawei;

import java.util.Scanner;

/**
 * 字符个数统计
 */
public class Ten {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int len = getLen(s);
            System.out.println(len);
        }
    }

    public static int getLen(String s) {
        int[] arr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)] = 1;
        }
        int len = 0;
        for (int value : arr) {
            if (value == 1) {
                len++;
            }
        }
        return len;
    }
}
