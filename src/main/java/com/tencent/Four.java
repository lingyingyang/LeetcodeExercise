package com.tencent;

import java.util.Scanner;

public class Four {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        int[] broads = new int[num];
        String[] strArr = in.nextLine().split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < strArr.length; i++) {
            int high = Integer.parseInt(strArr[i]);
            broads[i] = high;
            min = Math.min(high, min);
            max = Math.max(high, max);
        }
        int ans = 0;
        if (min >= num) {
            ans = num;
            System.out.println(ans);
        } else {
            ans = min;
            while (ans < num) {
                int lineNum = 0;
                boolean previousNum = false;
                for (int i = 0; i < broads.length; i++) {
                    broads[i] = broads[i] - min;
                    if (broads[i] != 0) {
                        previousNum = true;
                    } else {
                        if (previousNum) {
                            lineNum++;
                            previousNum = false;
                        }
                    }
                }
                if ((ans + lineNum) >= num) {
                    ans = num;
                    break;
                } else {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
