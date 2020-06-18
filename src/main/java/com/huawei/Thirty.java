package com.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 字符串合并处理
 */
public class Thirty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            StringBuffer rs = new StringBuffer();
            char[] strmx = (sc.next() + sc.next()).toCharArray();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < strmx.length; i++) {
                if (i % 2 == 0) {
                    sb1.append(strmx[i]);
                } else {
                    sb2.append(strmx[i]);
                }
            }
            char[] str1 = sb1.toString().toCharArray();
            char[] str2 = sb2.toString().toCharArray();
            Arrays.sort(str1);
            Arrays.sort(str2);
            StringBuilder sb = new StringBuilder();
            int k = 0;
            for (int i = 0; i < Math.min(str1.length, str2.length); i++) {
                sb.append(str1[i]);
                sb.append(str2[i]);
                if (i == Math.min(str1.length, str2.length) - 1) {
                    k = i;
                }
            }
            if (str1.length > str2.length) {
                sb.append(str1[k + 1]);
            } else if (str1.length < str2.length) {
                sb.append(str2[k + 1]);
            }
            char[] str = sb.toString().toCharArray();
            for (char c : str) {
                if (String.valueOf(c).matches("[A-Fa-f]")) {
                    String res = reverse(Integer.toBinaryString((int) Character.toLowerCase(c) - 87));
                    int x = Integer.parseInt(res, 2);
                    rs.append(Nx(x));
                } else if (String.valueOf(c).matches("[0-9]")) {
                    StringBuilder res = new StringBuilder();
                    String hex = Integer.toBinaryString(Integer.parseInt(String.valueOf(c)));
                    if (hex.length() < 4) {
                        for (int j = 0; j < 4 - hex.length(); j++) {
                            res.append("0");
                        }
                    }
                    String resx = reverse(res + hex);
                    int x = Integer.parseInt(resx, 2);
                    rs.append(Nx(x));
                } else {
                    rs.append(c);
                }
            }
            System.out.println(rs);
        }
    }

    public static String reverse(String srx) {
        StringBuilder sb = new StringBuilder();
        return sb.append(srx).reverse().toString();
    }

    public static String Nx(int x) {
        if (x == 10) {
            return "A";
        } else if (x == 11) {
            return "B";
        } else if (x == 12) {
            return "C";
        } else if (x == 13) {
            return "D";
        } else if (x == 14) {
            return "E";
        } else if (x == 15) {
            return "F";
        }
        return String.valueOf(x);
    }
}
