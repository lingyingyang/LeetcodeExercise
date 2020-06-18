package com.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        for (int i = 0; i < num; i++) {
            int len = Integer.parseInt(in.nextLine());
            if (len < 11) {
                ans.add("NO");
                in.nextLine();
            } else {
                int prefixLen = len - 11 + 1;
                String item = in.nextLine();
                String prefix = item.substring(0, prefixLen);
                StringBuilder expect = new StringBuilder();
                for (int j = 0; j < prefixLen; j++) {
                    expect.append('8');
                }
                if (!prefix.equals(expect.toString())) {
                    ans.add("NO");
                } else {
                    ans.add("YES");
                }
            }
        }

        for (String s : ans) {
            System.out.println(s);
        }
    }

}
