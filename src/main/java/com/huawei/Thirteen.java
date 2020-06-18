package com.huawei;

import java.util.Scanner;

/**
 * 句子逆序
 */
public class Thirteen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] list = s.split(" ");
            for (int i = list.length - 1; i >= 0; i--) {
                System.out.print(list[i] + " ");
            }
            System.out.println();
        }
    }
}
