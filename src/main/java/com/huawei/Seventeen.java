package com.huawei;

import java.util.Scanner;

/**
 * 坐标移动
 */
public class Seventeen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] arr = s.split(";");
            printResult(arr);
        }
    }

    private static void printResult(String[] arr) {
        int x = 0;
        int y = 0;
        for (String item : arr) {
            if (item.equals("")) continue;
            if (item.matches("^[ASWD]\\d+$")) {
                char position = item.charAt(0);
                int step = Integer.parseInt(item.substring(1));
                switch (position) {
                    case 'A':
                        x -= step;
                        break;
                    case 'S':
                        y -= step;
                        break;
                    case 'D':
                        x += step;
                        break;
                    case 'W':
                        y += step;
                        break;
                }
            }
        }
        System.out.println(String.format("%d,%d", x, y));
    }
}
