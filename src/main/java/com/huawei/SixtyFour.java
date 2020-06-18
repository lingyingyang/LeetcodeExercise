package com.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 24点游戏算法
 */
public class SixtyFour {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] in = line.split(" ");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                list.add(Integer.parseInt(in[i]));
            }
            boolean flag = fun(list);
            System.out.println(flag);
        }
    }

    public static boolean fun(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            list.remove(i);
            if (getResult(list, temp)) {
                return true;
            }
            list.add(i, temp);
        }
        return false;
    }

    public static boolean getResult(List<Integer> list, int temp) {
        if (list.size() == 0) return temp == 24;

        for (int i = 0; i < list.size(); i++) {
            int n = list.get(i);
            list.remove(i);
            if (getResult(list, temp * n)
                    || getResult(list, temp + n)
                    || getResult(list, temp - n)) {
                return true;
            } else if (temp % n == 0) {
                if (getResult(list, temp / n)) {
                    return true;
                }
            }
            list.add(i, n);
        }
        return false;
    }
}
