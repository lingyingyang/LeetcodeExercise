package com.huawei;

import java.util.Scanner;

/**
 * 质数因子
 */
public class Six {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long params = sc.nextLong();
        if (params < 2) {
            sc.close();
            return;
        }
        String result = getResult(params);
        System.out.println(result);
        sc.close();
    }

    public static String getResult(long ulDataInput) {
        StringBuilder str = new StringBuilder();
        int index = 2;
        while (index <= ulDataInput) {
            if (ulDataInput % index == 0) {
                if (index == ulDataInput) {
                    str.append(index).append(" ");
                    break;
                } else {
                    str.append(index).append(" ");
                    ulDataInput = ulDataInput / index;
                }
            } else {
                index++;
            }
        }
        return str.toString();
    }
}
