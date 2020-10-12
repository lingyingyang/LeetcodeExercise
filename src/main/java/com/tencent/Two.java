package com.tencent;

import leetcode.dp.PaintHouse;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int houses = Integer.parseInt(in.nextLine());
        int[][] costs = new int[houses][3];
        for (int i = 0; i < houses; i++) {
            String line = in.nextLine();
            String[] items = line.split(" ");
            costs[i][0] = Integer.parseInt(items[0]); // red
            costs[i][1] = Integer.parseInt(items[1]); // green
            costs[i][2] = Integer.parseInt(items[2]); // blue
        }

        int out = new PaintHouse().minCost(costs);
        System.out.println(out);
    }
}
