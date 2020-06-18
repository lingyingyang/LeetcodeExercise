package com.huawei;

import java.util.Scanner;

/**
 * 简单密码
 */
public class TwentyOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            char[] out = getResult(str);
            for (char c : out) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static char[] getResult(String str) {
        char[] out = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                if (ch == 'Z') out[i] = 'a';
                out[i] = (char) (ch + 33);
            } else if (ch >= 'a' && ch <= 'c') {
                out[i] = '2';
            } else if (ch >= 'd' && ch <= 'f') {
                out[i] = '3';
            } else if (ch >= 'g' && ch <= 'i') {
                out[i] = '4';
            } else if (ch >= 'j' && ch <= 'l') {
                out[i] = '5';
            } else if (ch >= 'm' && ch <= 'o') {
                out[i] = '6';
            } else if (ch >= 'p' && ch <= 's') {
                out[i] = '7';
            } else if (ch >= 't' && ch <= 'v') {
                out[i] = '8';
            } else if (ch >= 'w' && ch <= 'z') {
                out[i] = '9';
            } else {
                out[i] = ch;
            }
        }
        return out;
    }
}
