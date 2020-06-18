package com.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 线性插值
 */
public class FortyFive {
    public static String process(int[][] values) {
        int len = values.length;
        List<String> toFill = new ArrayList<>();
        int curNo = values[0][0], curV = values[0][1];
        for (int i = 1; i <= len - 1; i++) {
            if (values[i][0] - curNo > 1) {
                cal(curNo, curV, values[i][0], values[i][1], toFill);
                curNo = values[i][0];
                curV = values[i][1];
            } else if (values[i][0] - curNo == 1 || values[i][0] - curNo < 0) {
                toFill.add(curNo + " " + curV);
                curNo = values[i][0];
                curV = values[i][1];
            }
            //编号相等
        }
        toFill.add(curNo + " " + curV);
        StringBuilder res = new StringBuilder();
        for (String str : toFill) {
            res.append(str).append("\n");
        }
        return res.substring(0, res.length() - 1);
    }

    public static void cal(int smallNo, int smallV, int bigNo, int bigV, List<String> toFill) {
        toFill.add(smallNo + " " + smallV);
        int nums = bigNo - smallNo - 1;
        for (int i = 1; i <= nums; i++) {
            int curNo = smallNo + i;
            int curV = smallV + ((bigV - smallV) / (bigNo - smallNo)) * i;
            toFill.add(curNo + " " + curV);
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int M = in.nextInt();
            int N = in.nextInt();
            int[][] values = new int[M][2];
            for (int i = 0; i < M; i++) {
                values[i][0] = in.nextInt();
                values[i][1] = in.nextInt();
            }
            System.out.println(process(values));
        }
        in.close();
    }
}
