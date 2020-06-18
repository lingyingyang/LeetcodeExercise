package com.huawei;

import java.util.Scanner;

/**
 * 进制转换
 */
public class Five {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();
            System.out.println(fun(str.substring(2)));
        }
    }

    public static int fun(String s) {
        int ans = 0;
        int count = 0;
        int temp = 0;
        char ch;

        while (count < s.length()) {
            ch = s.charAt(s.length() - count - 1);
            if (ch >= '0' && ch <= '9') {
                temp = ch - '0';
            } else if (ch >= 'A' && ch <= 'Z') {
                temp = ch - 'A' + 10;
            } else if (ch >= 'a' && ch <= 'z') {
                temp = ch - 'a' + 10;
            } else {
                break;
            }
            ans += temp * Math.pow(16, count);
            count++;
        }

        return ans;
    }
}
