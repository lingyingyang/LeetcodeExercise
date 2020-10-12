package com.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Five {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String cmd = in.nextLine();
        int num = Integer.parseInt(in.nextLine());
        int turnNum = 0;
        List<Integer /*idx of T*/> turns = new ArrayList<>();
        for (int i = 0; i < cmd.length(); i++) {
            if (cmd.charAt(i) == 'T') {
                turnNum++;
                turns.add(i);
            }
        }
        if (num >= turnNum) {
            System.out.print(cmd.length());
        } else {
            for (int i = 0; i < num; i++) {
                int idx = 0;
                int max = turns.get(0);
                for (int j = 1; j < turns.size(); j++) {
                    int sub = turns.get(j) - turns.get(j - 1);
                    if (sub > max) {
                        idx = j;
                        max = sub;
                    }
                }
                turns.remove(idx);
            }

            int ans = 0;
            int prev = 0;
            for (int i = 0; i < turns.size(); i++) {
                int turn = turns.get(i);
                int curr = turn - prev;
                prev = turn;
                if (i % 2 == 0) {
                    ans += curr;
                } else {
                    ans -= curr;
                }
            }
            System.out.print(Math.abs(ans));
        }
    }
}
