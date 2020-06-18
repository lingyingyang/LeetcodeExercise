package com.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 扑克牌大小
 */
public class EightyFive {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            String[] ss = str.split("-");
            if (ss[0].equals("joker JOKER") || ss[1].equals("joker JOKER")) {
                System.out.println("joker JOKER");
                continue;
            }

            String[] str0 = ss[0].split(" ");
            String[] str1 = ss[1].split(" ");

            findString(str0);
            findString(str1);

            int len1 = str0.length, len2 = str1.length;
            if (len1 == 4 || len2 == 4) {
                if (len1 == 4 && len2 == 4) {
                    int temp = Integer.parseInt(str0[0]) - Integer.parseInt(str1[0]);
                    if (temp >= 0) {
                        System.out.println(ss[0]);
                    } else {
                        System.out.println(ss[1]);
                    }
                    continue;
                } else if (len1 == 4) {
                    System.out.println(ss[0]);
                    continue;
                } else {
                    System.out.println(ss[1]);
                    continue;
                }
            }
            if (len1 != len2) {
                System.out.println("ERROR");
                continue;
            }
            int temp = Integer.parseInt(str0[0]) - Integer.parseInt(str1[0]);
            if (temp >= 0) {
                System.out.println(ss[0]);
            } else {
                System.out.println(ss[1]);
            }
        }
    }

    private static String[] findString(String[] str) {
        for (int i = 0; i < str.length; i++) {
            switch (str[i]) {
                case "J":
                    str[i] = "11";
                    break;
                case "Q":
                    str[i] = "12";
                    break;
                case "K":
                    str[i] = "13";
                    break;
                case "A":
                    str[i] = "14";
                    break;
                case "2":
                    str[i] = "15";
                    break;
            }
        }

        return str;
    }
}
