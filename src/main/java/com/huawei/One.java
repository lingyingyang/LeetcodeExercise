package com.huawei;

import java.util.Scanner;

/**
 * 字符串最后一个的长度
 */
public class One {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = "";
        while (input.hasNextLine()) {
            s = input.nextLine();
            System.out.println(s.length() - 1 - s.lastIndexOf(" "));
        }
    }
}
