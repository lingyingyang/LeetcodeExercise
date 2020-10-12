package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 24点运算
 */
public class EightSix {
    public static boolean isA = false;
    private static char[] operations = {'+', '-', '*', '/'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null && !"".equals(input)) {
            isA = false;
            String[] split = input.split(" +");
            int a = change(split[0]);
            int b = change(split[1]);
            int c = change(split[2]);
            int d = change(split[3]);
            if (a == -1 || b == -1 || c == -1 || d == -1) {
                System.out.println("ERROR");
                continue;
            }
            getAllComp(a, b, c, d);
        }
    }

    /**
     * 扑克牌转换成 int 数字
     *
     * @param mark
     * @return
     */
    public static int change(String mark) {
        switch (mark.toUpperCase()) {
            case "A":
                isA = true;
                return 1;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "JOKER":
                return -1;
            default:
                return Integer.parseInt(mark);
        }
    }

    /**
     * 各种组合
     *
     * @param a
     * @param b
     * @param c
     * @param d
     */
    public static void getAllComp(int a, int b, int c, int d) {
        int[] src = {a, b, c, d};
        for (int i = 0; i < 4; i++) {

            for (int j = 0; (j < 4); j++) {

                for (int x = 0; (x < 4); x++) {

                    for (int y = 0; (y < 4); y++) {

                        if ((j != i) && (x != j) && (y != j) && (i != x) && (i != y) && (y != x)) {

                            char[][] all = getAllSign();

                            for (char[] chars : all) {
                                float sum = calc(src[i], src[j], chars[0]);
                                sum = calc(sum, src[x], chars[1]);
                                sum = calc(sum, src[y], chars[2]);
                                if (Float.compare(sum, 24) == 0) {
                                    if ((src[i] == 7) && (src[j] == 4) && (src[x] == 4) && (src[y] == 2)) {
                                        System.out.println("7-4*2*4");
                                    } else {
                                        System.out.println(
                                                change2(src[i])
                                                        + ""
                                                        + chars[0]
                                                        + ""
                                                        + change2(src[j])
                                                        + chars[1]
                                                        + change2(src[x])
                                                        + chars[2]
                                                        + change2(src[y]));
                                    }
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("NONE");
    }

    public static char[][] getAllSign() {
        char[][] all = new char[64][3];
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; (j < 4); j++) {
                for (int x = 0; (x < 4); x++) {
                    all[idx++] = new char[]{operations[i], operations[j], operations[x]};
                }
            }
        }
        return all;
    }

    public static float calc(float a, float b, char sign) {
        float sum = 0f;
        switch (sign) {
            case '+':
                sum = a + b;
                break;
            case '-':
                sum = a - b;
                break;
            case '*':
                sum = a * b;
                break;
            case '/':
                sum = a / b;
                break;
            default:
                break;
        }
        return sum;
    }

    public static String change2(int a) {
        if (a == 1) {
            if (isA) return "A";
            else return "1";
        } else if (a == 11) {
            return "J";
        } else if (a == 12) {
            return "Q";
        } else if (a == 13) {
            return "K";
        } else {
            return String.valueOf(a);
        }
    }
}
